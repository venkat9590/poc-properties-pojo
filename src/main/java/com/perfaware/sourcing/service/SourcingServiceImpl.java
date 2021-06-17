package com.perfaware.sourcing.service;

import java.util.*;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.JsonNode;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.perfaware.sourcing.model.*;
import com.perfaware.sourcing.model.request.*;
import com.perfaware.sourcing.model.response.CapacityAvailability;
import com.perfaware.sourcing.model.response.CapacityAvailabilityResponse;
import com.perfaware.sourcing.model.response.SourcingRequestResponse;
import com.perfaware.sourcing.persistence.type.SelectionCriterionType;
import com.perfaware.sourcing.service.criterias.CriteriaService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.perfaware.sourcing.persistence.repository.ShipNodeRepository;
import com.perfaware.sourcing.persistence.repository.SourcingRuleRepository;
import com.perfaware.sourcing.persistence.repository.SourcingRuleSelectionRepository;
import com.perfaware.sourcing.persistence.table.ShipNodeTable;
import com.perfaware.sourcing.persistence.table.SourcingRuleSelectionTable;
import com.perfaware.sourcing.persistence.table.SourcingRuleTable;
import com.perfaware.sourcing.persistence.type.NodeListType;
import org.springframework.web.client.RestTemplate;

@Service
public class SourcingServiceImpl implements SourcingService{

	private final ShipNodeRepository ShipNodeRepository;
	private final SourcingRuleSelectionRepository SourcingRuleSelectionRepository;
	private final SourcingRuleRepository SourcingRuleRepository;
	private static final ObjectMapper om = new ObjectMapper();
	private final SourcingRequestResponse sourcingRequestResponse;
	private CriteriaService criteriaService;

	@Autowired
	public SourcingServiceImpl(ShipNodeRepository ShipNodeRepository,SourcingRuleRepository SourcingRuleRepository,
			SourcingRuleSelectionRepository SourcingRuleSelectionRepository,ShipNodeTable ShipNodeTable,SourcingRequestResponse sourcingRequestResponse,CriteriaService criteriaService) {
		this.ShipNodeRepository = ShipNodeRepository;
		this.SourcingRuleRepository = SourcingRuleRepository;
		this.SourcingRuleSelectionRepository = SourcingRuleSelectionRepository;
		this.sourcingRequestResponse=sourcingRequestResponse;
		this.criteriaService = criteriaService;
	}



	/**
	 * API Group: ShipNode
	 * Inserts nodes into "ShipNode" table
	 * @return ResponseEntity
	 * @throws Exception 
	 */	

	@Override
	public ResponseEntity updateShipNode(List<ShipNodeRequest> requestInfoList) throws Exception{

		ShipNodeResponseObject respObj = ShipNodeResponseObject.builder().build();

		if (requestInfoList == null)
			//throw new IllegalRequestException("Illegal Request Body");

		for(ShipNodeRequest requestInfo : requestInfoList) {
			String nodeId = requestInfo.getNodeId();
			String orgCode = requestInfo.getOrgCode();
			
			//if(nodeId==null || orgCode==null )
				//throw new MissingAttributesException("Mandatory Attributes Missing for the Node, node_id: " + requestInfo.getNodeId() + ", org_code: " +requestInfo.getOrgCode() );
			
			String description = requestInfo.getDescription();
			String nodeType = requestInfo.getNodeType();
			String zipcode = requestInfo.getZipcode();
			double longitude= requestInfo.getLongitude();
			double latitude = requestInfo.getLatitude();
			double labourCost = requestInfo.getLaborCost();
			boolean isActive = requestInfo.isActive();
			boolean isShippingEnabled = requestInfo.isShippingEnabled();
			boolean isPickupEnabled = requestInfo.isPickupEnabled();
			boolean isBigStore = requestInfo.isBigStore();
			boolean isShutDown = requestInfo.isShutDown();
			boolean isColdStorageAvailable = requestInfo.isColdStorageAvailable();
			boolean isHazmatStorageAvailable = requestInfo.isHazmatStorageAvailable();

			ShipNodeRepository.updateShipNode(nodeId, orgCode, description, nodeType, zipcode, longitude, latitude, labourCost,
					isActive, isShippingEnabled, isPickupEnabled, isBigStore, isShutDown, isColdStorageAvailable, isHazmatStorageAvailable);
		}

		return ResponseEntity.noContent().build();

	}

	/** 
	 * API Group: ShipNode
	 * Retrieves particular node details from "ShipNode" table
	 */

	@Override
	public void getNodeDetails(String orgCode, String nodeId) {

		ShipNodeResponseObject respObj = ShipNodeResponseObject.builder().build();

		ShipNodeTable infoData = ShipNodeRepository.findByOrgCodeAndNodeId(orgCode, nodeId);

		if (infoData==null) {

			//throw new NotFoundException("Node id : "+ nodeId +", not found in Organization : " + orgCode);
		}
		else {			
			respObj.setShipNodeList(infoData);
			//return ResponseEntity.status(HttpStatus.OK).body(respObj);
		}

	}



	/** 
	 * API Group: ShipNode
	 * Deletes node from "ShipNode" table
	 * @return ResponseEntity
	 */	

	@Override
	public ResponseEntity<ShipNodeTable> deleteShipNode(String orgCode,String nodeId)
	{

		ShipNodeTable info = ShipNodeRepository.findByOrgCodeAndNodeId(orgCode, nodeId);

		if (info==null) {
			//throw new NotFoundException("Failed to Find Ship Node : "+ nodeId +" in Organization : "+ orgCode);
		}

		ShipNodeRepository.deleteShipNode(nodeId,orgCode);
		ShipNodeTable infoData = ShipNodeRepository.findByOrgCodeAndNodeId(orgCode, nodeId);

		return ResponseEntity.status(HttpStatus.OK).body(infoData);
	}



	/** 
	 * API Group: ShipNode
	 * Retrieves all the nodes from "ShipNode" table
	 * @return Response Entity object of all ShipNodeTable rows
	 */	

	@Override
	public ResponseEntity<List<ShipNodeTable>> getShipNodes()
	{

		List<ShipNodeTable> infoData = ShipNodeRepository.findAll();

		return ResponseEntity.status(HttpStatus.OK).body(infoData);
	}

	@Override
	public ResponseEntity updateSourcingRuleSelection(List<SourcingRuleSelectionReq> requestInfo) {
		return null;
	}

	@Override
	public ResponseEntity<List<SourcingRuleSelectionTable>> getSourcingRuleSelection() {
		return null;
	}

	@Override
	public ResponseEntity<Object> manageSourcingRule(List<SourcingRuleRequest> req) {
		return null;
	}

	//TODO: improve and standardize
	@Override
	public ResponseEntity<?> findSourcingRuleNew(Order orderRequest) throws Exception {

		SourcingRuleSelectionRes response = new SourcingRuleSelectionRes();

		String attribute1  = "$.fulfillment_type";
		String attribute2  = "$.ship_to.state";
		String attribute3  = "$.ship_to.city";

		String vertices1  = getValueOfJsonPath(orderRequest,attribute1);
		String vertices2  = getValueOfJsonPath(orderRequest,attribute2);
		String vertices3  = getValueOfJsonPath(orderRequest,attribute3);

		Map<String,String> hmpItemQty = new HashMap<>();
		//create item, qty map
		hmpItemQty = orderRequest.getOrderLines().stream().collect(Collectors.toMap(OrderLine::getItemId,OrderLine::getQuantity));
		
		String sourcingRuleID = graphDbCall(vertices1,vertices2,vertices3);
		System.out.println("SourcingRuleId: "+sourcingRuleID);

		if(sourcingRuleID==null || sourcingRuleID.isEmpty()){
			throw new Exception("Sourcing Rule ID cannot be null.");
		}

		SourcingRequestResponse sourcingRequestResponse = getSourcingNodes(sourcingRuleID,orderRequest.getEnterpriseCode(),hmpItemQty,orderRequest);
		return new ResponseEntity(sourcingRequestResponse,HttpStatus.OK);
	}



	private String graphDbCall(String vertices1, String vertices2, String vertices3) throws Exception {

		RestTemplate restTemplate = new RestTemplate();
		SourcingRuleIdRequest sourcingRuleIdRequest = new SourcingRuleIdRequest(vertices1,vertices2,vertices3);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<SourcingRuleIdRequest> entity 	= new HttpEntity<SourcingRuleIdRequest>(sourcingRuleIdRequest,headers);

		String response = restTemplate.exchange("http://localhost:8083/v1/getSourcingRuleId", HttpMethod.POST, entity, String.class).getBody();
		System.out.println("response "+response);

		ObjectMapper om = new ObjectMapper();
		JsonNode node = om.readTree(response);
		if(node.get("sourcing_rule")!=null){
			return node.get("sourcing_rule").asText();
		}
		else if(node.get("alt_sourcing_rule")!=null){
			return node.get("alt_sourcing_rule").asText();
		}
		else{
			throw new Exception("No Sourcing Rule found, Please contact system administrator.");
		}

	}


	//TODO: remove
	private String getValueOfJsonPath(Order orderRequest, String attribute1) throws JsonProcessingException {

		String json=om.writeValueAsString(orderRequest);
		Object document = Configuration.defaultConfiguration().jsonProvider().parse(json);

		return JsonPath.read(document, attribute1);
	}

	//TODO: improve and stardardize
	@Override
	public SourcingRequestResponse getSourcingNodes(String sourcingRuleId, String orgCode,Map<String,String> hmpItemQty,Order orderRequest) throws Exception {
		
		List<SourcingRuleTable> allSequences = SourcingRuleRepository.fetchSequences(orgCode, sourcingRuleId);
		
		Map<String, ShipNodeTable> nodeDetails = new HashMap<>();
		Map<String, Map<String, Object>> nodesWithInventoryMap = new HashMap<String, Map<String, Object>>();

		if(allSequences.size()==0){
			throw new Exception("No sourcing rule found.");
		}
		Map<String,List<String>> hmpItemAndStores = new HashMap<>();
		List<String> storeListForCriteria= new ArrayList<>();
		for(SourcingRuleTable sequence : allSequences) {
			System.out.println("SequenceData: "+sequence.toString());
			List<NodeListType> nodeList = sequence.getNodeList();
			List<String> seqNodes = nodeList.stream().map(p -> p.getNodeId()).collect(Collectors.toList());
			List<ShipNodeTable> nodeData = ShipNodeRepository.findAllNodes(orgCode, seqNodes);
			List<SelectionCriterionType> criterias = sequence.getNodeSelectionCriteria();
			for (ShipNodeTable node : nodeData) {
				nodeDetails.put(node.getKey().getNodeId(), node);
			}
			//get inv map for items from graph
			for (String key : hmpItemQty.keySet()) {
				RestTemplate restTemplate = new RestTemplate();
				InvCacheRecForItems invCacheRecForItems = new InvCacheRecForItems(orgCode, key, hmpItemQty.get(key));
				HttpHeaders headers = new HttpHeaders();
				headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
				HttpEntity<InvCacheRecForItems> entity = new HttpEntity<>(invCacheRecForItems, headers);

				String response = restTemplate.exchange("http://localhost:8083/v1/getInvCache", HttpMethod.POST, entity, String.class).getBody();
				JSONObject jsonResponse = new JSONObject(response);
				JSONArray stores = jsonResponse.getJSONArray("stores");
				List<String> storeInvList = new ArrayList<>();
				for (int i = 0; i < stores.length(); i++) {
					storeInvList.add(stores.getString(i));
				}
				//find the intersection og inv and seq stores
				storeInvList.retainAll(seqNodes);
				if(storeListForCriteria.size()==0){
					storeListForCriteria.addAll(storeInvList);
				}
				else{
					storeListForCriteria.retainAll(storeInvList);
				}
				hmpItemAndStores.put(key, storeInvList);
			}
			//iterate over sequence criterias
			storeListForCriteria = criteriaService.determineCriteriaFlow(criterias,storeListForCriteria,nodeDetails,orderRequest);
		}

		//find capacity
		//TODO: create a separate service and impl for this
		//TODO: Optimize
		RestTemplate restTemplate = new RestTemplate();
		CapacityAvailabilityRequest capacityAvailabilityRequest = CapacityAvailabilityRequest.builder()
																  .stores(storeListForCriteria)
																  .availabilityDate("2021-02-12")
																  .deliveryMethod(orderRequest.getDeliveryMethod())
																  .orgCode(orderRequest.getEnterpriseCode())
																  .build();
		System.out.println("Capaity Request: "+capacityAvailabilityRequest.toString());
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<InvCacheRecForItems> entity = new HttpEntity(capacityAvailabilityRequest, headers);

		String response = restTemplate.exchange("http://localhost:8091/capacity/data/v1/getAvailability", HttpMethod.POST, entity, String.class).getBody();
		System.out.println("response " + response);
		sourcingRequestResponse.setSeqStores(storeListForCriteria);
		ObjectMapper objectMapper = new ObjectMapper();
		CapacityAvailabilityResponse capacityAvailabilityResponse = objectMapper.readValue(response,CapacityAvailabilityResponse.class);
		sourcingRequestResponse.setCapacityAvailabilities(capacityAvailabilityResponse.getCapacityAvailability());
		return sourcingRequestResponse;
	}


}
