package com.zoho.crm.sample.modules;

import java.lang.reflect.Field;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;

import java.util.Arrays;

import java.util.List;

import java.util.Map;

import com.zoho.crm.api.HeaderMap;

import com.zoho.crm.api.customviews.Criteria;

import com.zoho.crm.api.customviews.CustomView;
import com.zoho.crm.api.customviews.SharedTo;
import com.zoho.crm.api.modules.APIException;

import com.zoho.crm.api.modules.ActionHandler;

import com.zoho.crm.api.modules.ActionResponse;

import com.zoho.crm.api.modules.ActionWrapper;

import com.zoho.crm.api.modules.Argument;

import com.zoho.crm.api.modules.BodyWrapper;

import com.zoho.crm.api.modules.Module;

import com.zoho.crm.api.modules.ModulesOperations;

import com.zoho.crm.api.modules.ModulesOperations.GetModulesHeader;

import com.zoho.crm.api.modules.RelatedListProperties;

import com.zoho.crm.api.modules.ResponseHandler;

import com.zoho.crm.api.modules.ResponseWrapper;

import com.zoho.crm.api.modules.SuccessResponse;

import com.zoho.crm.api.profiles.Profile;

import com.zoho.crm.api.util.APIResponse;

import com.zoho.crm.api.util.Model;

public class Modules
{
	/**
	 * <h3>Get Modules</h3> This method is used to get metadata about all the modules and print the response.
	 * 
	 * @throws Exception
	 */
	public static void getModules() throws Exception
	{
		// Get instance of ModulesOperations Class
		ModulesOperations moduleOperations = new ModulesOperations();

		HeaderMap headerInstance = new HeaderMap();

		OffsetDateTime ifmodifiedsince = OffsetDateTime.of(2020, 05, 20, 10, 00, 00, 01, ZoneOffset.of("+05:30"));

		headerInstance.add(GetModulesHeader.IF_MODIFIED_SINCE, ifmodifiedsince);

		// Call getModules method that takes headerInstance as parameters
		APIResponse<ResponseHandler> response = moduleOperations.getModules(headerInstance);

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

					// Get the list of obtained Module instances
					List<Module> modules = responseWrapper.getModules();

					for (Module module : modules)
					{
						// Get the GlobalSearchSupported of each Module
						System.out.println("Module GlobalSearchSupported: " + module.getGlobalSearchSupported());

						// Get the Deletable of each Module
						System.out.println("Module Deletable: " + module.getDeletable());

						// Get the Description of each Module
						System.out.println("Module Description: " + module.getDescription());

						// Get the Creatable of each Module
						System.out.println("Module Creatable: " + module.getCreatable());

						// Get the InventoryTemplateSupported of each Module
						System.out.println("Module InventoryTemplateSupported: " + module.getInventoryTemplateSupported());

						if (module.getModifiedTime() != null)
						{
							// Get the ModifiedTime of each Module
							System.out.println("Module ModifiedTime: " + module.getModifiedTime());
						}

						// Get the PluralLabel of each Module
						System.out.println("Module PluralLabel: " + module.getPluralLabel());

						// Get the PresenceSubMenu of each Module
						System.out.println("Module PresenceSubMenu: " + module.getPresenceSubMenu());

						// Get the TriggersSupported of each Module
						System.out.println("Module TriggersSupported: " + module.getTriggersSupported());

						// Get the Id of each Module
						System.out.println("Module Id: " + module.getId());

						// check if blueprint is supported for each Module
						System.out.println("Module IsBlueprintSupported: " + module.getIsblueprintsupported());

						// Get the Visibility of each Module
						System.out.println("Module visible: " + module.getVisible());

						// Get the Visibility of each Module
						System.out.println("Module Visibility: " + module.getVisibility());

						// Get the Convertable of each Module
						System.out.println("Module Convertable: " + module.getConvertable());

						// Get the Editable of each Module
						System.out.println("Module Editable: " + module.getEditable());

						// Get the EmailtemplateSupport of each Module
						System.out.println("Module EmailtemplateSupport: " + module.getEmailtemplateSupport());

						// Get List of properties field APIName
						List<String> onDemandProperties = module.getOnDemandProperties();

						if (onDemandProperties != null)
						{
							for (Object fieldName : onDemandProperties)
							{
								// Get the Field Name
								System.out.println("Module onDemandProperties Fields: " + fieldName);
							}
						}
						// Get the list of Profile instance each Module
						List<Profile> profiles = module.getProfiles();

						// Check if profiles is not null
						if (profiles != null)
						{
							for (Profile profile : profiles)
							{
								// Get the Name of each Profile
								System.out.println("Module Profile Name: " + profile.getName());

								// Get the Id of each Profile
								System.out.println("Module Profile Id: " + profile.getId());
							}
						}

						// Get the FilterSupported of each Module
						System.out.println("Module FilterSupported: " + module.getFilterSupported());

						// Get the ShowAsTab of each Module
						System.out.println("Module ShowAsTab: " + module.getShowAsTab());

						// Get the WebLink of each Module
						System.out.println("Module WebLink: " + module.getWebLink());

						// Get the SequenceNumber of each Module
						System.out.println("Module SequenceNumber: " + module.getSequenceNumber());

						// Get the SingularLabel of each Module
						System.out.println("Module SingularLabel: " + module.getSingularLabel());

						// Get the Viewable of each Module
						System.out.println("Module Viewable: " + module.getViewable());

						// Get the APISupported of each Module
						System.out.println("Module APISupported: " + module.getAPISupported());

						// Get the APIName of each Module
						System.out.println("Module APIName: " + module.getAPIName());

						// Get the QuickCreate of each Module
						System.out.println("Module QuickCreate: " + module.getQuickCreate());

						// Get the modifiedBy User instance of each Module
						com.zoho.crm.api.users.User modifiedBy = module.getModifiedBy();

						// Check if modifiedBy is not null
						if (modifiedBy != null)
						{
							// Get the name of the modifiedBy User
							System.out.println("Module Modified By User-Name: " + modifiedBy.getName());

							// Get the ID of the modifiedBy User
							System.out.println("Module Modified By User-ID: " + modifiedBy.getId());
						}

						// Get the GeneratedType of each Module
						System.out.println("Module GeneratedType: " + module.getGeneratedType().getValue());

						// Get the FeedsRequired of each Module
						System.out.println("Module FeedsRequired: " + module.getFeedsRequired());

						// Get the ScoringSupported of each Module
						System.out.println("Module ScoringSupported: " + module.getScoringSupported());

						// Get the WebformSupported of each Module
						System.out.println("Module WebformSupported: " + module.getWebformSupported());

						// Get the list of Argument instance each Module
						List<Argument> arguments = module.getArguments();

						// Check if arguments is not null
						if (arguments != null)
						{
							for (Argument argument : arguments)
							{
								// Get the Name of each Argument
								System.out.println("Module Argument Name: " + argument.getName());

								// Get the Value of each Argument
								System.out.println("Module Argument Value: " + argument.getValue());
							}
						}

						// Get the ModuleName of each Module
						System.out.println("Module ModuleName: " + module.getModuleName());

						// Get the BusinessCardFieldLimit of each Module
						System.out.println("Module BusinessCardFieldLimit: " + module.getBusinessCardFieldLimit());

						// Get the parentModule Module instance of each Module
						Module parentModule = module.getParentModule();

						// Check if arguments is not null
						if (parentModule != null && parentModule.getAPIName() != null)
						{
							// Get the Name of Parent Module
							System.out.println("Module Parent Module Name: " + parentModule.getAPIName());

							// Get the Value of Parent Module
							System.out.println("Module Parent Module Id: " + parentModule.getId());
						}
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
	 * <h3>Get Module</h3> This method is used to get metadata about single module with it's API Name and print the response.
	 * 
	 * @param apiName The API Name of the module to obtain metadata
	 * @throws Exception
	 */
	public static void getModule(String moduleAPIName) throws Exception
	{
		// example
		// String moduleAPIName = "Leads";

		// Get instance of ModulesOperations Class
		ModulesOperations moduleOperations = new ModulesOperations();

		// Call getModule method that takes moduleAPIName as parameter
		APIResponse<ResponseHandler> response = moduleOperations.getModule(moduleAPIName);

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

					// Get the list of obtained Module instances
					List<Module> modules = responseWrapper.getModules();

					for (Module module : modules)
					{
						// Get the GlobalSearchSupported of each Module
						System.out.println("Module GlobalSearchSupported: " + module.getGlobalSearchSupported());

						if (module.getKanbanView() != null)
						{
							// Get the KanbanView of each Module
							System.out.println("Module KanbanView: " + module.getKanbanView());
						}

						// Get the Deletable of each Module
						System.out.println("Module Deletable: " + module.getDeletable());

						// Get the Description of each Module
						System.out.println("Module Description: " + module.getDescription());

						// Get the Creatable of each Module
						System.out.println("Module Creatable: " + module.getCreatable());

						if (module.getFilterStatus() != null)
						{
							// Get the FilterStatus of each Module
							System.out.println("Module FilterStatus: " + module.getFilterStatus());
						}

						// Get the InventoryTemplateSupported of each Module
						System.out.println("Module InventoryTemplateSupported: " + module.getInventoryTemplateSupported());

						if (module.getModifiedTime() != null)
						{
							// Get the ModifiedTime of each Module
							System.out.println("Module ModifiedTime: " + module.getModifiedTime());
						}

						// Get the PluralLabel of each Module
						System.out.println("Module PluralLabel: " + module.getPluralLabel());

						// Get the PresenceSubMenu of each Module
						System.out.println("Module PresenceSubMenu: " + module.getPresenceSubMenu());

						// Get the TriggersSupported of each Module
						System.out.println("Module TriggersSupported: " + module.getTriggersSupported());

						// Get the Id of each Module
						System.out.println("Module Id: " + module.getId());

						// check if blueprint is supported for each Module
						System.out.println("Module IsBlueprintSupported : " + module.getIsblueprintsupported());

						// Get the RelatedListProperties instance of each Module
						RelatedListProperties relatedListProperties = module.getRelatedListProperties();

						// Check if relatedListProperties is not null
						if (relatedListProperties != null)
						{
							// Get the SortBy of each RelatedListProperties
							System.out.println("Module RelatedListProperties SortBy: " + relatedListProperties.getSortBy());

							// Get List of fields APIName
							List<String> fields = relatedListProperties.getFields();

							// Check if fields is not null
							if (fields != null)
							{
								for (Object fieldName : fields)
								{
									// Get the Field Name
									System.out.println("Module RelatedListProperties Fields: " + fieldName);
								}
							}

							// Get the Name of RelatedListProperties
							System.out.println("Module RelatedListProperties SortOrder: " + relatedListProperties.getSortOrder());
						}

						// Get the PerPage of each Module
						System.out.println("Module PerPage: " + module.getPerPage());

						// Get List of properties field APIName
						List<String> properties = module.getProperties();

						// Check if properties is not null
						if (properties != null)
						{
							for (Object fieldName : properties)
							{
								// Get the Field Name
								System.out.println("Module Properties Fields: " + fieldName);
							}
						}

						// Get the Visibility of each Module
						System.out.println("Module visible: " + module.getVisible());

						// Get the Visibility of each Module
						System.out.println("Module Visibility: " + module.getVisibility());

						// Get the Convertable of each Module
						System.out.println("Module Convertable: " + module.getConvertable());

						// Get the Editable of each Module
						System.out.println("Module Editable: " + module.getEditable());

						// Get the EmailtemplateSupport of each Module
						System.out.println("Module EmailtemplateSupport: " + module.getEmailtemplateSupport());

						// Get the list of Profile instance each Module
						List<Profile> profiles = module.getProfiles();

						// Check if profiles is not null
						if (profiles != null)
						{
							for (Profile profile : profiles)
							{
								// Get the Name of each Profile
								System.out.println("Module Profile Name: " + profile.getName());

								// Get the Id of each Profile
								System.out.println("Module Profile Id: " + profile.getId());
							}
						}

						// Get the FilterSupported of each Module
						System.out.println("Module FilterSupported: " + module.getFilterSupported());

						// Get List of properties field APIName
						List<String> onDemandProperties = module.getOnDemandProperties();

						if (onDemandProperties != null)
						{
							for (Object fieldName : onDemandProperties)
							{
								// Get the Field Name
								System.out.println("Module onDemandProperties Fields: " + fieldName);
							}
						}

						// Get the DisplayField of each Module
						System.out.println("Module DisplayField: " + module.getDisplayField());

						// Get List of SearchLayoutFields APIName
						List<String> searchLayoutFields = module.getSearchLayoutFields();

						// Check if searchLayoutFields is not null
						if (searchLayoutFields != null)
						{
							for (Object fieldName : searchLayoutFields)
							{
								// Get the Field Name
								System.out.println("Module SearchLayoutFields Fields: " + fieldName);
							}
						}

						if (module.getKanbanViewSupported() != null)
						{
							// Get the KanbanViewSupported of each Module
							System.out.println("Module KanbanViewSupported: " + module.getKanbanViewSupported());
						}

						// Get the ShowAsTab of each Module
						System.out.println("Module ShowAsTab: " + module.getShowAsTab());

						// Get the WebLink of each Module
						System.out.println("Module WebLink: " + module.getWebLink());

						// Get the SequenceNumber of each Module
						System.out.println("Module SequenceNumber: " + module.getSequenceNumber());

						// Get the SingularLabel of each Module
						System.out.println("Module SingularLabel: " + module.getSingularLabel());

						// Get the Viewable of each Module
						System.out.println("Module Viewable: " + module.getViewable());

						// Get the APISupported of each Module
						System.out.println("Module APISupported: " + module.getAPISupported());

						// Get the APIName of each Module
						System.out.println("Module APIName: " + module.getAPIName());

						// Get the QuickCreate of each Module
						System.out.println("Module QuickCreate: " + module.getQuickCreate());

						// Get the modifiedBy User instance of each Module
						com.zoho.crm.api.users.User modifiedBy = module.getModifiedBy();

						// Check if modifiedBy is not null
						if (modifiedBy != null)
						{
							// Get the name of the modifiedBy User
							System.out.println("Module Modified By User-Name: " + modifiedBy.getName());

							// Get the ID of the modifiedBy User
							System.out.println("Module Modified By User-ID: " + modifiedBy.getId());
						}

						// Get the GeneratedType of each Module
						System.out.println("Module GeneratedType: " + module.getGeneratedType().getValue());

						// Get the FeedsRequired of each Module
						System.out.println("Module FeedsRequired: " + module.getFeedsRequired());

						// Get the ScoringSupported of each Module
						System.out.println("Module ScoringSupported: " + module.getScoringSupported());

						// Get the WebformSupported of each Module
						System.out.println("Module WebformSupported: " + module.getWebformSupported());

						// Get the list of Argument instance each Module
						List<Argument> arguments = module.getArguments();

						// Check if arguments is not null
						if (arguments != null)
						{
							for (Argument argument : arguments)
							{
								// Get the Name of each Argument
								System.out.println("Module Argument Name: " + argument.getName());

								// Get the Value of each Argument
								System.out.println("Module Argument Value: " + argument.getValue());
							}
						}

						// Get the ModuleName of each Module
						System.out.println("Module ModuleName: " + module.getModuleName());

						// Get the BusinessCardFieldLimit of each Module
						System.out.println("Module BusinessCardFieldLimit: " + module.getBusinessCardFieldLimit());

						// Get the CustomView instance of each Module
						CustomView customView = module.getCustomView();

						// Check if customView is not null
						if (customView != null)
						{
							printCustomView(customView);
						}

						// Get the parentModule Module instance of each Module
						Module parentModule = module.getParentModule();

						// Check if arguments is not null
						if (parentModule != null && parentModule.getAPIName() != null)
						{
							// Get the Name of Parent Module
							System.out.println("Module Parent Module Name: " + parentModule.getAPIName());

							// Get the Value of Parent Module
							System.out.println("Module Parent Module Id: " + parentModule.getId());
						}
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

					if (exception.getDetails() != null)
					{
						// Get the details map
						for (Map.Entry<String, Object> entry : exception.getDetails().entrySet())
						{
							// Get each value in the map
							System.out.println(entry.getKey() + ": " + entry.getValue());
						}
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

	private static void printCustomView(CustomView customView)
	{
		// Get the DisplayValue of the CustomView
		System.out.println("Module CustomView DisplayValue: " + customView.getDisplayValue());

		if (customView.getCreatedTime() != null)
		{
			// Get the CreatedTime of each Module
			System.out.println("Module CustomView CreatedTime: " + customView.getCreatedTime());
		}

		// Get the AccessType of the CustomView
		System.out.println("Module CustomView AccessType: " + customView.getAccessType());

		// Get the Criteria instance of the CustomView
		Criteria criteria = customView.getCriteria();

		// Check if criteria is not null
		if (criteria != null)
		{
			printCriteria(criteria);
		}

		// Get the SystemName of the CustomView
		System.out.println("Module CustomView SystemName: " + customView.getSystemName());

		// Get the SortBy of the CustomView
		System.out.println("Module CustomView SortBy: " + customView.getSortBy());

		// Get the CreatedBy User instance of each Module
		com.zoho.crm.api.users.User createdBy = customView.getCreatedBy();

		// Check if createdBy is not null
		if (createdBy != null)
		{
			// Get the name of the createdBy User
			System.out.println("Module Created By User-Name: " + createdBy.getName());

			// Get the ID of the createdBy User
			System.out.println("Module Created By User-ID: " + createdBy.getId());
		}

		List<SharedTo> sharedToDetails = customView.getSharedTo();

		if (sharedToDetails != null)
		{
			for (SharedTo sharedTo : sharedToDetails)
			{
				// Get the Name of the each sharedTo
				System.out.println("SharedDetails Name: " + sharedTo.getName());

				// Get the ID of the each sharedTo
				System.out.println("SharedDetails ID: " + sharedTo.getId());

				// Get the Type of the each sharedTo
				System.out.println("SharedDetails Type: " + sharedTo.getType());

				// Get the Subordinates of the each sharedTo
				System.out.println("SharedDetails Subordinates: " + sharedTo.getSubordinates());
			}
		}

		// Get the Default of the CustomView
		System.out.println("Module CustomView Default: " + customView.getDefault());

		if (customView.getModifiedTime() != null)
		{
			// Get the ModifiedTime of each Module
			System.out.println("Module CustomView ModifiedTime: " + customView.getModifiedTime());
		}

		// Get the Name of the CustomView
		System.out.println("Module CustomView Name: " + customView.getName());

		// Get the SystemDefined of the CustomView
		System.out.println("Module CustomView SystemDefined: " + customView.getSystemDefined());

		// Get the ModifiedBy User instance of each Module
		com.zoho.crm.api.users.User modifiedBy = customView.getModifiedBy();

		// Check if modifiedBy is not null
		if (modifiedBy != null)
		{
			// Get the name of the modifiedBy User
			System.out.println("Module Modified By User-Name: " + modifiedBy.getName());

			// Get the ID of the modifiedBy User
			System.out.println("Module Modified By User-ID: " + modifiedBy.getId());
		}

		// Get the ID of the CustomView
		System.out.println("Module CustomView ID: " + customView.getId());

		// Get the list of string
		List<com.zoho.crm.api.fields.Field> fields = customView.getFields();

		if (fields != null)
		{
			for (com.zoho.crm.api.fields.Field field : fields)
			{
				System.out.println("Module CustomView Field Id: " + field.getId());

				System.out.println("Module CustomView Field APIName: " + field.getAPIName());
			}
		}

		// Get the Category of the CustomView
		System.out.println("Module CustomView Category: " + customView.getCategory());

		if (customView.getLastAccessedTime() != null)
		{
			// Get the LastAccessedTime of each Module
			System.out.println("Module CustomView LastAccessedTime: " + customView.getLastAccessedTime());
		}

		if (customView.getFavorite() != null)
		{
			// Get the Favorite of the CustomView
			System.out.println("Module CustomView Favorite: " + customView.getFavorite());
		}

		if (customView.getSortOrder() != null)
		{
			// Get the SortOrder of the CustomView
			System.out.println("Module CustomView SortOrder: " + customView.getSortOrder());
		}
	}

	private static void printCriteria(Criteria criteria)
	{
		if (criteria.getComparator() != null)
		{
			// Get the Comparator of the Criteria
			System.out.println("Module CustomView Criteria Comparator: " + criteria.getComparator().getValue());
		}

		// Get the Field of the Criteria
		com.zoho.crm.api.fields.Field field = criteria.getField();

		if (field != null)
		{
			System.out.println("CustomView Criteria Field: " + field.getAPIName());

			System.out.println("Module CustomView Criteria Value: " + field.getId());
		}

		if (criteria.getValue() != null)
		{
			// Get the Value of the Criteria
			System.out.println("Module CustomView Criteria Value: " + criteria.getValue());
		}

		// Get the List of Criteria instance of each Criteria
		List<Criteria> criteriaGroup = criteria.getGroup();

		if (criteriaGroup != null)
		{
			for (Criteria criteria1 : criteriaGroup)
			{
				printCriteria(criteria1);
			}
		}

		// Get the Group Operator of the Criteria
		System.out.println("Module CustomView Criteria Group Operator: " + criteria.getGroupOperator());
	}

	/**
	 * <h3>Update Module By APIName</h3> This method is used to update module details using module APIName and print the response.
	 * 
	 * @param moduleAPIName The API Name of the module to update
	 * @throws Exception
	 */
	public static void updateModuleByAPIName(String moduleAPIName) throws Exception
	{
		// example
		// String moduleAPIName = "Leads";

		// Get instance of ModulesOperations Class
		ModulesOperations moduleOperations = new ModulesOperations();

		List<Module> modules = new ArrayList<Module>();

		List<Profile> profiles = new ArrayList<Profile>();

		// Get instance of Profile Class
		Profile profile = new Profile();

		// To set the Profile Id
		profile.setId(34770610026014l);

//		profile.setDelete(true);

		profiles.add(profile);

		Module module = new Module();

		module.setProfiles(profiles);

		modules.add(module);

		BodyWrapper request = new BodyWrapper();

		request.setModules(modules);

		// Call updateModuleByAPIName method that takes moduleAPIName and BodyWrapper instance as parameter
		APIResponse<ActionHandler> response = moduleOperations.updateModuleByAPIName(moduleAPIName, request);

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
					List<ActionResponse> actionResponses = actionWrapper.getModules();

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

					if (exception.getDetails() != null)
					{
						// Get the details map
						for (Map.Entry<String, Object> entry : exception.getDetails().entrySet())
						{
							// Get each value in the map
							System.out.println(entry.getKey() + ": " + entry.getValue());
						}
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
	 * <h3>Update Module By Id</h3> This method is used to update module details using module Id and print the response.
	 * 
	 * @param moduleId - The Id of the module to obtain metadata
	 * @throws Exception
	 */
	public static void updateModuleById(Long moduleId) throws Exception
	{
		// example
		// Long moduleId = 34770613905003L;

		// Get instance of ModulesOperations Class
		ModulesOperations moduleOperations = new ModulesOperations();

		List<Module> modules = new ArrayList<Module>();

		List<Profile> profiles = new ArrayList<Profile>();

		// Get instance of Profile Class
		Profile profile = new Profile();

		profile.setId(34770610026014l);

//		profile.setDelete(true);

		profiles.add(profile);

		Module module = new Module();

		module.setProfiles(profiles);

		module.setAPIName("apiName1");

		modules.add(module);

		BodyWrapper request = new BodyWrapper();

		request.setModules(modules);

		// Call updateModuleById method that takes moduleId and BodyWrapper instance as parameter
		APIResponse<ActionHandler> response = moduleOperations.updateModuleById(moduleId, request);

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
					List<ActionResponse> actionResponses = actionWrapper.getModules();

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

					if (exception.getDetails() != null)
					{
						// Get the details map
						for (Map.Entry<String, Object> entry : exception.getDetails().entrySet())
						{
							// Get each value in the map
							System.out.println(entry.getKey() + ": " + entry.getValue());
						}
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
