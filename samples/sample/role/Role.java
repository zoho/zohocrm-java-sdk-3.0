package com.zoho.crm.sample.role;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

import java.util.Map;

import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.roles.APIException;
import com.zoho.crm.api.roles.ActionHandler;
import com.zoho.crm.api.roles.ActionResponse;
import com.zoho.crm.api.roles.ActionWrapper;
import com.zoho.crm.api.roles.BodyWrapper;
import com.zoho.crm.api.roles.ResponseHandler;

import com.zoho.crm.api.roles.ResponseWrapper;

import com.zoho.crm.api.roles.RolesOperations;
import com.zoho.crm.api.roles.RolesOperations.DeleteRoleParam;
import com.zoho.crm.api.roles.SuccessResponse;
import com.zoho.crm.api.users.User;
import com.zoho.crm.api.util.APIResponse;

import com.zoho.crm.api.util.Model;

public class Role
{
	/**
	 * <h3>Get Roles</h3> This method is used to retrieve the data of roles through an API request and print the response.
	 * 
	 * @throws Exception
	 */
	public static void getRoles() throws Exception
	{
		// Get instance of RolesOperations Class
		RolesOperations rolesOperations = new RolesOperations();

		// Call getRoles method
		APIResponse<ResponseHandler> response = rolesOperations.getRoles();

		if (response != null)
		{
			// Get the status code from response
			System.out.println("Status Code: " + response.getStatusCode());

			if (Arrays.asList(204, 304).contains(response.getStatusCode()))
			{
				System.out.println(response.getStatusCode() == 204 ? "No Content" : "Not Modified");
				return;
			}

			// Check if expected response is received
			if (response.isExpected())
			{
				// Get object from response
				ResponseHandler responseHandler = response.getObject();

				if (responseHandler instanceof ResponseWrapper)
				{
					// Get the received ResponseWrapper instance
					ResponseWrapper responseWrapper = (ResponseWrapper) responseHandler;

					// Get the list of obtained Role instances
					List<com.zoho.crm.api.roles.Role> roles = responseWrapper.getRoles();

					for (com.zoho.crm.api.roles.Role role : roles)
					{
						// Get the DisplayLabel of each Role
						System.out.println("Role DisplayLabel: " + role.getDisplayLabel());

						// Get the forecastManager User instance of each Role
						com.zoho.crm.api.users.User forecastManager = role.getForecastManager();

						// Check if forecastManager is not null
						if (forecastManager != null)
						{
							// Get the ID of the forecast Manager
							System.out.println("Role Forecast Manager User-ID: " + forecastManager.getId());

							// Get the name of the forecast Manager
							System.out.println("Role Forecast Manager User-Name: " + forecastManager.getName());
						}

						// Get the ShareWithPeers of each Role
						System.out.println("Role ShareWithPeers: " + role.getShareWithPeers().toString());

						// Get the Name of each Role
						System.out.println("Role Name: " + role.getName());

						// Get the Description of each Role
						System.out.println("Role Description: " + role.getDescription());

						// Get the Id of each Role
						System.out.println("Role ID: " + role.getId());

						// Get the reportingTo User instance of each Role
						com.zoho.crm.api.users.User reportingTo = role.getReportingTo();

						// Check if reportingTo is not null
						if (reportingTo != null)
						{
							// Get the ID of the reportingTo User
							System.out.println("Role ReportingTo User-ID: " + reportingTo.getId());

							// Get the name of the reportingTo User
							System.out.println("Role ReportingTo User-Name: " + reportingTo.getName());
						}

						// Get the AdminUser of each Role
						System.out.println("Role AdminUser: " + role.getAdminUser());
					}
				}
				// Check if the request returned an exception
				else if (responseHandler instanceof APIException)
				{
					// Get the received APIException instance
					APIException exception = (APIException) responseHandler;

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
				java.lang.reflect.Field[] fields = clas.getDeclaredFields();

				for (java.lang.reflect.Field field : fields)
				{
					// Get each value
					System.out.println(field.getName() + ":" + field.get(responseObject));
				}
			}
		}
	}

	public static void createRoles() throws Exception
	{
		// Get instance of RolesOperations Class
		RolesOperations rolesOperations = new RolesOperations();

		// Get instance of BodyWrapper Class that will contain the request body
		BodyWrapper bodyWrapper = new BodyWrapper();

		// List of Role instances
		List<com.zoho.crm.api.roles.Role> roles = new ArrayList<com.zoho.crm.api.roles.Role>();

		// Get instance of Role Class
		com.zoho.crm.api.roles.Role role = new com.zoho.crm.api.roles.Role();

		// Set name of the Role
		role.setName("Product Manager321");

		User reportingTo = new User();

		reportingTo.setId(34770610026005l);

		role.setReportingTo(reportingTo);

		role.setDescription("Schedule and manage resources");

		role.setShareWithPeers(true);

		// Add ContactRole instance to the list
		roles.add(role);

		// Set the list to roles in BodyWrapper instance
		bodyWrapper.setRoles(roles);

		// Call createRoles method that takes BodyWrapper instance as parameter
		APIResponse<ActionHandler> response = rolesOperations.createRoles(bodyWrapper);

		if (response != null)
		{
			// Get the status code from response
			System.out.println("Status Code: " + response.getStatusCode());

			// Check if expected response is received
			if (response.isExpected())
			{
				// Get object from response
				ActionHandler actionHandler = response.getObject();

				if (actionHandler instanceof ActionWrapper)
				{
					// Get the received ActionWrapper instance
					ActionWrapper actionWrapper = (ActionWrapper) actionHandler;

					// Get the list of obtained ActionResponse instances
					List<ActionResponse> actionResponses = actionWrapper.getRoles();

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

	public static void updateRoles() throws Exception
	{
		// Get instance of RolesOperations Class
		RolesOperations rolesOperations = new RolesOperations();

		// Get instance of BodyWrapper Class that will contain the request body
		BodyWrapper bodyWrapper = new BodyWrapper();

		// List of Role instances
		List<com.zoho.crm.api.roles.Role> roles = new ArrayList<com.zoho.crm.api.roles.Role>();

		// Get instance of Role Class
		com.zoho.crm.api.roles.Role role = new com.zoho.crm.api.roles.Role();

		role.setId(347706114911002l);

		// Set name of the Role
		role.setName("Product Manager321123");

		User reportingTo = new User();

		reportingTo.setId(34770610026008l);

		role.setReportingTo(reportingTo);

		role.setDescription("Schedule and manage resources");

		role.setShareWithPeers(true);

		// Add ContactRole instance to the list
		roles.add(role);

		// Set the list to roles in BodyWrapper instance
		bodyWrapper.setRoles(roles);

		// Call updateRoles method that takes BodyWrapper instance as parameter
		APIResponse<ActionHandler> response = rolesOperations.updateRoles(bodyWrapper);

		if (response != null)
		{
			// Get the status code from response
			System.out.println("Status Code: " + response.getStatusCode());

			// Check if expected response is received
			if (response.isExpected())
			{
				// Get object from response
				ActionHandler actionHandler = response.getObject();

				if (actionHandler instanceof ActionWrapper)
				{
					// Get the received ActionWrapper instance
					ActionWrapper actionWrapper = (ActionWrapper) actionHandler;

					// Get the list of obtained ActionResponse instances
					List<ActionResponse> actionResponses = actionWrapper.getRoles();

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

	/**
	 * <h3>Get Role</h3> This method is used to retrieve the data of single role through an API request and print the response.
	 * 
	 * @param roleId The ID of the Role to be obtained
	 * @throws Exception
	 */
	public static void getRole(Long roleId) throws Exception
	{
		// example
		// Long roleId = 34770613881;

		// Get instance of RolesOperations Class
		RolesOperations rolesOperations = new RolesOperations();

		// Call getRole method that takes roleId as parameter
		APIResponse<ResponseHandler> response = rolesOperations.getRole(roleId);

		if (response != null)
		{
			// Get the status code from response
			System.out.println("Status Code: " + response.getStatusCode());

			if (Arrays.asList(204, 304).contains(response.getStatusCode()))
			{
				System.out.println(response.getStatusCode() == 204 ? "No Content" : "Not Modified");
				return;
			}

			// Check if expected response is received
			if (response.isExpected())
			{
				// Get object from response
				ResponseHandler responseHandler = response.getObject();

				if (responseHandler instanceof ResponseWrapper)
				{
					// Get the received ResponseWrapper instance
					ResponseWrapper responseWrapper = (ResponseWrapper) responseHandler;

					// Get the list of obtained Role instances
					List<com.zoho.crm.api.roles.Role> roles = responseWrapper.getRoles();

					for (com.zoho.crm.api.roles.Role role : roles)
					{
						// Get the DisplayLabel of each Role
						System.out.println("Role DisplayLabel: " + role.getDisplayLabel());

						// Get the forecastManager User instance of each Role
						com.zoho.crm.api.users.User forecastManager = role.getForecastManager();

						// Check if forecastManager is not null
						if (forecastManager != null)
						{
							// Get the ID of the forecast Manager
							System.out.println("Role Forecast Manager User-ID: " + forecastManager.getId());

							// Get the name of the forecast Manager
							System.out.println("Role Forecast Manager User-Name: " + forecastManager.getName());
						}

						// Get the ShareWithPeers of each Role
						System.out.println("Role ShareWithPeers: " + role.getShareWithPeers().toString());

						// Get the Name of each Role
						System.out.println("Role Name: " + role.getName());

						// Get the Description of each Role
						System.out.println("Role Description: " + role.getDescription());

						// Get the Id of each Role
						System.out.println("Role ID: " + role.getId());

						// Get the reportingTo User instance of each Role
						com.zoho.crm.api.users.User reportingTo = role.getReportingTo();

						// Check if reportingTo is not null
						if (reportingTo != null)
						{
							// Get the ID of the reportingTo User
							System.out.println("Role ReportingTo User-ID: " + reportingTo.getId());

							// Get the name of the reportingTo User
							System.out.println("Role ReportingTo User-Name: " + reportingTo.getName());
						}

						// Get the AdminUser of each Role
						System.out.println("Role AdminUser: " + role.getAdminUser());
					}
				}
				// Check if the request returned an exception
				else if (responseHandler instanceof APIException)
				{
					// Get the received APIException instance
					APIException exception = (APIException) responseHandler;

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
				java.lang.reflect.Field[] fields = clas.getDeclaredFields();

				for (java.lang.reflect.Field field : fields)
				{
					// Get each value
					System.out.println(field.getName() + ":" + field.get(responseObject));
				}
			}
		}
	}

	public static void updateRole(Long roleId) throws Exception
	{
		// Get instance of RolesOperations Class
		RolesOperations rolesOperations = new RolesOperations();

		// Get instance of BodyWrapper Class that will contain the request body
		BodyWrapper bodyWrapper = new BodyWrapper();

		// List of Role instances
		List<com.zoho.crm.api.roles.Role> roles = new ArrayList<com.zoho.crm.api.roles.Role>();

		// Get instance of Role Class
		com.zoho.crm.api.roles.Role role = new com.zoho.crm.api.roles.Role();

		// Set name of the Role
		role.setName("Product Manager3421");

		User reportingTo = new User();

		reportingTo.setId(34770610026008l);

		role.setReportingTo(reportingTo);

		role.setDescription("Schedule and manage resources");

		role.setShareWithPeers(true);

		// Add ContactRole instance to the list
		roles.add(role);

		// Set the list to roles in BodyWrapper instance
		bodyWrapper.setRoles(roles);

		// Call updateRoles method that takes roleId and BodyWrapper instance as parameter
		APIResponse<ActionHandler> response = rolesOperations.updateRole(roleId, bodyWrapper);

		if (response != null)
		{
			// Get the status code from response
			System.out.println("Status Code: " + response.getStatusCode());

			// Check if expected response is received
			if (response.isExpected())
			{
				// Get object from response
				ActionHandler actionHandler = response.getObject();

				if (actionHandler instanceof ActionWrapper)
				{
					// Get the received ActionWrapper instance
					ActionWrapper actionWrapper = (ActionWrapper) actionHandler;

					// Get the list of obtained ActionResponse instances
					List<ActionResponse> actionResponses = actionWrapper.getRoles();

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

	public static void deleteRole(Long roleId) throws Exception
	{
		// Get instance of RolesOperations Class
		RolesOperations rolesOperations = new RolesOperations();

		ParameterMap paramInstance = new ParameterMap();

		paramInstance.add(DeleteRoleParam.TRANSFER_TO_ID, 34770610026008l);

		// Call deleteRole method that takes roleId and paramInstance as parameter
		APIResponse<ActionHandler> response = rolesOperations.deleteRole(roleId, paramInstance);

		if (response != null)
		{
			// Get the status code from response
			System.out.println("Status Code: " + response.getStatusCode());

			// Check if expected response is received
			if (response.isExpected())
			{
				// Get object from response
				ActionHandler actionHandler = response.getObject();

				if (actionHandler instanceof ActionWrapper)
				{
					// Get the received ActionWrapper instance
					ActionWrapper actionWrapper = (ActionWrapper) actionHandler;

					// Get the list of obtained ActionResponse instances
					List<ActionResponse> actionResponses = actionWrapper.getRoles();

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