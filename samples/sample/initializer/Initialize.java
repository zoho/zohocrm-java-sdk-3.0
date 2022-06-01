package com.zoho.crm.sample.initializer;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.api.authenticator.store.DBStore;
import com.zoho.api.authenticator.store.FileStore;

import com.zoho.api.authenticator.store.TokenStore;
import com.zoho.api.logger.Logger;
import com.zoho.api.logger.Logger.Builder;
import com.zoho.api.logger.Logger.Levels;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.RequestProxy;
import com.zoho.crm.api.SDKConfig;
import com.zoho.crm.api.UserSignature;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.dc.USDataCenter;

public class Initialize
{
	public static void main(String[] args) throws Exception
	{
		initialize();
	}

	public static void initialize() throws Exception
	{
		/*
		 * Create an instance of Logger Class that takes two parameters 
		 * level -> Level of the log messages to be logged. Can be configured by typing Levels "." and choose any level from the list displayed. filePath -> Absolute file path, where messages need to be logged.
		 */
		Logger logger = new Logger.Builder()
		.filePath("/Users/Documents/zohocrm-java-sdk-sample/sdk_log.log")
		.level(Levels.INFO)
		.build();

		// Create an UserSignature instance that takes user Email as parameter
		UserSignature user = new UserSignature("abc@zoho.com");

		/*
		 * Configure the environment which is of the pattern Domain.Environment 
		 * Available Domains: USDataCenter, EUDataCenter, INDataCenter, CNDataCenter, AUDataCenter 
		 * Available Environments: PRODUCTION, DEVELOPER, SANDBOX
		 */
		Environment environment = USDataCenter.PRODUCTION;

		/*
		 * Create a Token instance 
		 * 1 -> OAuth client id. 
		 * 2 -> OAuth client secret. 
		 * 3 -> REFRESH/GRANT token. 
		 * 4 -> token type. 
		 * 5 -> OAuth redirect URL.
		 */
		Token token = new OAuthToken.Builder()
		.clientID("1000.xxxx")
		.clientSecret("xxxx")
//		.refreshToken("1.xxxx.xxxx")
		.redirectURL("https://www.zoho.com")
		.grantToken("1000.xxxx.xxx")
//		.accessToken("1000.xxx.xxxx")
		.build();

		/*
		 * Create an instance of TokenStore. 
		 * 1 -> DataBase host name. Default "jdbc:mysql://localhost" 
		 * 2 -> DataBase name. Default "zohooauth" 
		 * 3 -> DataBase user name. Default "root" 
		 * 4 -> DataBase password. Default "" 
		 * 5 -> DataBase port number. Default "3306"
		 */
		// TokenStore tokenstore = new DBStore();

		// TokenStore tokenstore = new DBStore.Builder().tableName("oauthtoken1").password("").build();

		TokenStore tokenstore = new FileStore("/Users/Documents/zohocrm-java-sdk-sample/java_sdk_token.txt");

		SDKConfig config = new SDKConfig.Builder().autoRefreshFields(true).pickListValidation(false).build();

		String resourcePath = "/Users/Documents/zohocrm-java-sdk-sample";

		/*
		 * Create an instance of RequestProxy 1 -> proxyHost 2 -> proxyPort 3 -> proxyUser 4 -> password 5 -> userDomain
		 */
//		RequestProxy requestProxy = new RequestProxy.Builder()
//				.host("proxyHost")
//				.port(80)
//				.user("proxyUser")
//				.password("password")
//				.userDomain("userDomain")
//				.build();

		new Initializer.Builder()
		.user(user)
		.environment(environment)
		.token(token)
		.SDKConfig(config)
		.store(tokenstore)
		.resourcePath(resourcePath)
		.logger(logger)
		.initialize();
	}
}
