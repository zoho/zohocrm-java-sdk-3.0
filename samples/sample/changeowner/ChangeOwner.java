//$Id$
package com.zoho.crm.sample.changeowner;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.zoho.crm.api.changeowner.APIException;
import com.zoho.crm.api.changeowner.ActionResponse;
import com.zoho.crm.api.changeowner.BodyWrapper;
import com.zoho.crm.api.changeowner.ChangeOwnerOperations;
import com.zoho.crm.api.changeowner.RecordActionHandler;
import com.zoho.crm.api.changeowner.RecordActionWrapper;
import com.zoho.crm.api.changeowner.SuccessResponse;
import com.zoho.crm.api.users.User;
import com.zoho.crm.api.util.APIResponse;

import com.zoho.crm.api.util.Model;

public class ChangeOwner
{
	public static void updateRecordsOwner(String moduleAPIName) throws Exception
	{
		// Get instance of ChangeOwnerOperations Class
		ChangeOwnerOperations changeOwnerOperations = new ChangeOwnerOperations(moduleAPIName);

		// Get instance of BodyWrapper Class that will contain the request body
		BodyWrapper bodyWrapper = new BodyWrapper();

		// List of record id
		List<String> Ids = new ArrayList<String>();

		Ids.add("347706114612001");

		Ids.add("347706114611002");

		bodyWrapper.setIds(Ids);

		User owner = new User();

		owner.setId(34770615791024l);

		bodyWrapper.setOwner(owner);

		bodyWrapper.setNotify(true);

		List<com.zoho.crm.api.modules.Module> relatedModules = new ArrayList<com.zoho.crm.api.modules.Module>();

		// Get instance of Module Class
		com.zoho.crm.api.modules.Module relatedModule = new com.zoho.crm.api.modules.Module();

		// Set ID to the Module instance
		relatedModule.setId(347706114686005l);

		// Set name to the Module instance
		relatedModule.setAPIName("Tasks");

		// Add Module instance to the list
		relatedModules.add(relatedModule);

		relatedModule = new com.zoho.crm.api.modules.Module();

		// Set ID to the Module instance
		relatedModule.setId(347706114686005l);

		// Set name to the Module instance
		relatedModule.setAPIName("Tasks");

		// Add Module instance to the list
		relatedModules.add(relatedModule);

		// Set the list to relatedModules in BodyWrapper instance
		bodyWrapper.setRelatedModules(relatedModules);

		// Call updateByModule method that takes BodyWrapper instance as parameter
		APIResponse<RecordActionHandler> response = changeOwnerOperations.updateRecordsOwner(bodyWrapper);

		if (response != null)
		{
			// Get the status code from response
			System.out.println("Status Code: " + response.getStatusCode());

			// Check if expected response is received
			if (response.isExpected())
			{
				// Get object from response
				RecordActionHandler actionHandler = response.getObject();

				if (actionHandler instanceof RecordActionWrapper)
				{
					// Get the received RecordActionWrapper instance
					RecordActionWrapper actionWrapper = (RecordActionWrapper) actionHandler;

					// Get the list of obtained ActionResponse instances
					List<ActionResponse> actionResponses = actionWrapper.getData();

					for (ActionResponse actionResponse : actionResponses)
					{
						// Check if the request is successful
						if (actionResponse instanceof SuccessResponse)
						{
							// Get the received SuccessResponse instance
							SuccessResponse successResponse = (SuccessResponse) actionResponse;

							// Get the Status
							System.out.println("Status: " + successResponse.getStatus().getValue());

							// Get the Code
							System.out.println("Code: " + successResponse.getCode().getValue());

							System.out.println("Details: ");

							// Get the details map
							for (Map.Entry<String, Object> entry : successResponse.getDetails().entrySet())
							{
								// Get each value in the map
								System.out.println(entry.getKey() + ": " + entry.getValue());
							}

							// Get the Message
							System.out.println("Message: " + successResponse.getMessage().getValue());
						}
						// Check if the request returned an exception
						else if (actionResponse instanceof APIException)
						{
							// Get the received APIException instance
							APIException exception = (APIException) actionResponse;

							// Get the Status
							System.out.println("Status: " + exception.getStatus().getValue());

							// Get the Code
							System.out.println("Code: " + exception.getCode().getValue());

							System.out.println("Details: ");

							// Get the details map
							for (Map.Entry<String, Object> entry : exception.getDetails().entrySet())
							{
								// Get each value in the map
								System.out.println(entry.getKey() + ": " + entry.getValue());
							}

							// Get the Message
							System.out.println("Message: " + exception.getMessage().getValue());
						}
					}
				}
				// Check if the request returned an exception
				else if (actionHandler instanceof APIException)
				{
					// Get the received APIException instance
					APIException exception = (APIException) actionHandler;

					// Get the Status
					System.out.println("Status: " + exception.getStatus().getValue());

					// Get the Code
					System.out.println("Code: " + exception.getCode().getValue());

					System.out.println("Details: ");

					// Get the details map
					for (Map.Entry<String, Object> entry : exception.getDetails().entrySet())
					{
						// Get each value in the map
						System.out.println(entry.getKey() + ": " + entry.getValue());
					}

					// Get the Message
					System.out.println("Message: " + exception.getMessage().getValue());
				}
			}
			else
			{// If response is not as expected

				// Get model object from response
				Model responseObject = response.getModel();

				// Get the response object's class
				Class<? extends Model> clas = responseObject.getClass();

				// Get all declared fields of the response class
				Field[] fields = clas.getDeclaredFields();

				for (Field field : fields)
				{
					// Get each value
					System.out.println(field.getName() + ":" + field.get(responseObject));
				}
			}
		}
	}

	public static void updateRecordOwner(String moduleAPIName, Long recordId) throws Exception
	{
		// ID of the Record to be updated
		// Long recordId = 5255085067923l;

		// Get instance of ChangeOwnerOperations Class
		ChangeOwnerOperations changeOwnerOperations = new ChangeOwnerOperations(moduleAPIName);

		// Get instance of BodyWrapper Class that will contain the request body
		BodyWrapper bodyWrapper = new BodyWrapper();

		User owner = new User();

		owner.setId(34770615791024l);

		bodyWrapper.setOwner(owner);

		bodyWrapper.setNotify(true);

		List<com.zoho.crm.api.modules.Module> relatedModules = new ArrayList<com.zoho.crm.api.modules.Module>();

		// Get instance of Module Class
		com.zoho.crm.api.modules.Module relatedModule = new com.zoho.crm.api.modules.Module();

		// Set ID to the Module instance
		relatedModule.setId(347706114686005l);

		// Set name to the Module instance
		relatedModule.setAPIName("Tasks");

		// Add Module instance to the list
		relatedModules.add(relatedModule);

		relatedModule = new com.zoho.crm.api.modules.Module();

		// Set ID to the Module instance
		relatedModule.setId(347706114686005l);

		// Set name to the Module instance
		relatedModule.setAPIName("Tasks");

		// Add Module instance to the list
		relatedModules.add(relatedModule);

		// Set the list to relatedModules in BodyWrapper instance
		bodyWrapper.setRelatedModules(relatedModules);

		// Call updateRecordOwner method that takes recordId and BodyWrapper instance as parameters
		APIResponse<RecordActionHandler> response = changeOwnerOperations.updateRecordOwner(recordId, bodyWrapper);

		if (response != null)
		{
			// Get the status code from response
			System.out.println("Status Code: " + response.getStatusCode());

			// Check if expected response is received
			if (response.isExpected())
			{
				// Get object from response
				RecordActionHandler actionHandler = response.getObject();

				if (actionHandler instanceof RecordActionWrapper)
				{
					// Get the received ActionWrapper instance
					RecordActionWrapper actionWrapper = (RecordActionWrapper) actionHandler;

					// Get the list of obtained ActionResponse instances
					List<ActionResponse> actionResponses = actionWrapper.getData();

					for (ActionResponse actionResponse : actionResponses)
					{
						// Check if the request is successful
						if (actionResponse instanceof SuccessResponse)
						{
							// Get the received SuccessResponse instance
							SuccessResponse successResponse = (SuccessResponse) actionResponse;

							// Get the Status
							System.out.println("Status: " + successResponse.getStatus().getValue());

							// Get the Code
							System.out.println("Code: " + successResponse.getCode().getValue());

							System.out.println("Details: ");

							// Get the details map
							for (Map.Entry<String, Object> entry : successResponse.getDetails().entrySet())
							{
								// Get each value in the map
								System.out.println(entry.getKey() + ": " + entry.getValue());
							}

							// Get the Message
							System.out.println("Message: " + successResponse.getMessage().getValue());
						}
						// Check if the request returned an exception
						else if (actionResponse instanceof APIException)
						{
							// Get the received APIException instance
							APIException exception = (APIException) actionResponse;

							// Get the Status
							System.out.println("Status: " + exception.getStatus().getValue());

							// Get the Code
							System.out.println("Code: " + exception.getCode().getValue());

							System.out.println("Details: ");

							// Get the details map
							for (Map.Entry<String, Object> entry : exception.getDetails().entrySet())
							{
								// Get each value in the map
								System.out.println(entry.getKey() + ": " + entry.getValue());
							}

							// Get the Message
							System.out.println("Message: " + exception.getMessage().getValue());
						}
					}
				}
				// Check if the request returned an exception
				else if (actionHandler instanceof APIException)
				{
					// Get the received APIException instance
					APIException exception = (APIException) actionHandler;

					// Get the Status
					System.out.println("Status: " + exception.getStatus().getValue());

					// Get the Code
					System.out.println("Code: " + exception.getCode().getValue());

					System.out.println("Details: ");

					// Get the details map
					for (Map.Entry<String, Object> entry : exception.getDetails().entrySet())
					{
						// Get each value in the map
						System.out.println(entry.getKey() + ": " + entry.getValue());
					}

					// Get the Message
					System.out.println("Message: " + exception.getMessage().getValue());
				}
			}
			else
			{// If response is not as expected

				// Get model object from response
				Model responseObject = response.getModel();

				// Get the response object's class
				Class<? extends Model> clas = responseObject.getClass();

				// Get all declared fields of the response class
				Field[] fields = clas.getDeclaredFields();

				for (Field field : fields)
				{
					// Get each value
					System.out.println(field.getName() + ":" + field.get(responseObject));
				}
			}
		}
	}
}
