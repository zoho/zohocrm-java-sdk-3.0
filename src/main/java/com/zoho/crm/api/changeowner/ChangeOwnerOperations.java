package com.zoho.crm.api.changeowner;

import com.zoho.crm.api.exception.SDKException;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.CommonAPIHandler;
import com.zoho.crm.api.util.Constants;

public class ChangeOwnerOperations
{
	private String moduleAPIName;

	/**
	 * Creates an instance of ChangeOwnerOperations with the given parameters
	 * @param moduleAPIName A String representing the moduleAPIName
	 */
	public ChangeOwnerOperations(String moduleAPIName)
	{
		 this.moduleAPIName = moduleAPIName;


	}

	/**
	 * The method to update record owner
	 * @param recordId A Long representing the recordId
	 * @param request An instance of BodyWrapper
	 * @return An instance of APIResponse<RecordActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<RecordActionHandler> updateRecordOwner(Long recordId, BodyWrapper request) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v3/");

		apiPath = apiPath.concat( this.moduleAPIName.toString());

		apiPath = apiPath.concat("/");

		apiPath = apiPath.concat(recordId.toString());

		apiPath = apiPath.concat("/actions/change_owner");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_CREATE);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.setMandatoryChecker(true);

		return handlerInstance.apiCall(RecordActionHandler.class, "application/json");

	}

	/**
	 * The method to update records owner
	 * @param request An instance of BodyWrapper
	 * @return An instance of APIResponse<RecordActionHandler>
	 * @throws SDKException
	 */
	public APIResponse<RecordActionHandler> updateRecordsOwner(BodyWrapper request) throws SDKException
	{
		CommonAPIHandler handlerInstance = new CommonAPIHandler();

		String apiPath = new String();

		apiPath = apiPath.concat("/crm/v3/");

		apiPath = apiPath.concat( this.moduleAPIName.toString());

		apiPath = apiPath.concat("/actions/change_owner");

		handlerInstance.setAPIPath(apiPath);

		handlerInstance.setHttpMethod(Constants.REQUEST_METHOD_POST);

		handlerInstance.setCategoryMethod(Constants.REQUEST_CATEGORY_CREATE);

		handlerInstance.setContentType("application/json");

		handlerInstance.setRequest(request);

		handlerInstance.setMandatoryChecker(true);

		return handlerInstance.apiCall(RecordActionHandler.class, "application/json");

	}
}