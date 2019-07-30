package com.lcl.erefill.core.services.integ.telus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import javax.xml.ws.Holder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lcl.erefill.core.common.entity.ERefillToken;
import com.lcl.erefill.core.common.telus.response.AccountAliasResponse;
import com.lcl.erefill.core.common.telus.response.AddAccountAliasResponse;
import com.lcl.erefill.core.common.telus.response.ChangeMyAccountPasswordResponse;
import com.lcl.erefill.core.common.telus.response.LogOnResponse;
import com.lcl.erefill.core.common.telus.response.LogOnUserResponse;
import com.lcl.erefill.core.common.telus.response.UpdateAccountAliasResponse;
import com.lcl.erefill.core.common.telus.response.UpdatePasswordReminderResponse;
import com.lcl.erefill.core.common.telus.response.UpdatePreferencesResponse;
import com.lcl.erefill.core.common.telus.response.UserAccountGroup;
import com.lcl.erefill.core.config.ERefillConfigService;
import com.lcl.erefill.core.constants.ERefillConstants;
import com.lcl.erefill.core.exception.ERefillApplicationException;
import com.lcl.erefill.core.exception.ERefillBusinessException;
import com.lcl.erefill.core.exception.ErrorHandler;
import com.lcl.erefill.core.services.BaseService;
import com.lcl.erefill.core.utils.CommonUtils;
import com.lcl.erefill.core.utils.PropertyUtil;
import com.lcl.erefill.core.vo.Account;
import com.lcl.erefill.core.vo.AccountPreferenceVO;
import com.lcl.erefill.core.vo.PasswordReminder;
import com.lcl.erefill.generated.telus.session.ISessionSvcAddAccountAliasErrorFaultFaultMessage;
import com.lcl.erefill.generated.telus.session.ISessionSvcChangePasswordErrorFaultFaultMessage;
import com.lcl.erefill.generated.telus.session.ISessionSvcConfirmEmailErrorFaultFaultMessage;
import com.lcl.erefill.generated.telus.session.ISessionSvcEmailValidErrorFaultFaultMessage;
import com.lcl.erefill.generated.telus.session.ISessionSvcGetAccountAliasesErrorFaultFaultMessage;
import com.lcl.erefill.generated.telus.session.ISessionSvcGetConfirmEmailErrorFaultFaultMessage;
import com.lcl.erefill.generated.telus.session.ISessionSvcGetConfirmMobilePhoneNumberErrorFaultFaultMessage;
import com.lcl.erefill.generated.telus.session.ISessionSvcGetCurrentAccountErrorFaultFaultMessage;
import com.lcl.erefill.generated.telus.session.ISessionSvcGetPasswordReminderErrorFaultFaultMessage;
import com.lcl.erefill.generated.telus.session.ISessionSvcGetUserRoleErrorFaultFaultMessage;
import com.lcl.erefill.generated.telus.session.ISessionSvcListPreferencesErrorFaultFaultMessage;
import com.lcl.erefill.generated.telus.session.ISessionSvcLogOffErrorFaultFaultMessage;
import com.lcl.erefill.generated.telus.session.ISessionSvcLogOnErrorFaultFaultMessage;
import com.lcl.erefill.generated.telus.session.ISessionSvcLogOnUserErrorFaultFaultMessage;
import com.lcl.erefill.generated.telus.session.ISessionSvcSendPasswordErrorFaultFaultMessage;
import com.lcl.erefill.generated.telus.session.ISessionSvcUnsubscribeCommunicationErrorFaultFaultMessage;
import com.lcl.erefill.generated.telus.session.ISessionSvcUpdateAccountAliasErrorFaultFaultMessage;
import com.lcl.erefill.generated.telus.session.ISessionSvcUpdatePasswordReminderErrorFaultFaultMessage;
import com.lcl.erefill.generated.telus.session.ISessionSvcUpdatePreferencesErrorFaultFaultMessage;
import com.lcl.erefill.generated.telus.session.ISessionSvcVerifyIdentityErrorFaultFaultMessage;
import com.lcl.erefill.generated.telus.session.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring;
import com.lcl.erefill.generated.telus.session.rxassystlib.EConfirmEmailReturnCode;
import com.lcl.erefill.generated.telus.session.rxassystlib.EEmailReturnCode;
import com.lcl.erefill.generated.telus.session.rxassystlib.EPatientVerification;
import com.lcl.erefill.generated.telus.session.rxassystlib.LogOnDetail;
import com.lcl.erefill.generated.telus.session.rxassystlib_contracts.AccountAlias;
import com.lcl.erefill.generated.telus.session.rxassystlib_contracts.AccountAliases;
import com.lcl.erefill.generated.telus.session.rxassystlib_contracts.AccountPreference;
import com.lcl.erefill.generated.telus.session.rxassystlib_contracts.AccountPreferenceEAccountPreferenceType;
import com.lcl.erefill.generated.telus.session.rxassystlib_contracts.ArrayOfAccountPreference;
import com.lcl.erefill.generated.telus.session.rxassystlib_contracts.ConfirmEmailReturnCode;
import com.lcl.erefill.generated.telus.session.rxassystlib_contracts.EmailReturnStatus;
import com.lcl.erefill.generated.telus.session.rxassystlib_contracts.PasswordRecovery;
import com.lcl.erefill.generated.telus.session.rxassystlib_contracts.User;
import com.lcl.erefill.generated.telus.session.rxassystlib_contracts.UserAccountsGroup;
import com.lcl.erefill.generated.telus.session.rxassystlib_contracts.UserToken;
import com.lcl.erefill.generated.telus.session.rxassystlib_contracts.VerifyIdentityReason;
import com.lcl.erefill.generated.telus.session.rxassystlib_contracts.VerifyUserInput;
import com.lcl.erefill.generated.telus.session.rxassystlib_contracts.VerifyUserInputs;

@Component
public class SessionWSImpl extends BaseService {
	@Autowired
	private PropertyUtil propertyUtil;

	private static final Logger log = LoggerFactory.getLogger(SessionWSImpl.class);

	public LogOnResponse logOn(com.lcl.erefill.core.vo.User userR) {
		UserToken userToken = null;
		LogOnResponse logOnResponse = new LogOnResponse();
		try {
			User user = new User();
			user.setUserName(userR.getUsername());
			user.setPassword(userR.getPassword());
			long startTime = System.currentTimeMillis();
			userToken = getSessionService().logOn(user, null);
			log.info(ERefillConstants.EXTERNAL_SRVC_LOGON + "|"
					+ CommonUtils.executionTime(startTime));
			logOnResponse.setStatus(userToken.getStatus().get(0));
			logOnResponse.setToken(CommonUtils.byteArrayAsString(userToken
					.getToken().getValue()));
		} catch (ISessionSvcLogOnErrorFaultFaultMessage e) {
			log.error("SessionService ISessionSvcLogOnErrorFaultFaultMessage Block"
					+ e.getMessage());
			logOnResponse.setStatus(e.getFaultInfo().getType().get(0));
		} catch (Error e) {
			log.error("SessionService Error Block" + e.getMessage());
			ErrorHandler.handleError(e);
		} catch (Exception e) {
			log.error("SessionService Exception Block" + e.getMessage());
			if (e.getMessage().toString()
					.contains(ERefillConstants.STATUS_INVALID_USER_PASSWORD)) {
				logOnResponse
						.setStatus(ERefillConstants.STATUS_INVALID_USER_PASSWORD);
			} else if (e.getMessage().toString()
					.contains(ERefillConstants.STATUS_MINOR_USER)) {
				logOnResponse.setStatus(ERefillConstants.STATUS_MINOR_USER);
			} else {
				ErrorHandler.handleException(e);
			}
		}
		return logOnResponse;
	}
	
	public  LogOnUserResponse logOnUser(com.lcl.erefill.core.vo.User userR) {
		//UserToken userToken = null;
		LogOnUserResponse logOnUserResponse = new LogOnUserResponse();
		Holder<LogOnDetail> logOnDetail = new Holder<LogOnDetail>();
		Holder<UserToken> userTokenHolder = new Holder<UserToken>();
		try {
			User user = new User();
			user.setUserName(userR.getUsername());
			user.setPassword(userR.getPassword());
			long startTime = System.currentTimeMillis();
			//userToken = 
			getSessionService().logOnUser(user,63, null, userTokenHolder, logOnDetail);
			log.info(ERefillConstants.EXTERNAL_SRVC_LOGON + "|"
					+ CommonUtils.executionTime(startTime));
									
			logOnUserResponse.setStatus(userTokenHolder.value.getStatus().get(0));
			logOnUserResponse.setToken(CommonUtils.byteArrayAsString(userTokenHolder.value
					.getToken().getValue()));
			
			
			
			logOnUserResponse.setLogOnDetail(logOnDetail.value);
			
		} catch (ISessionSvcLogOnUserErrorFaultFaultMessage e) {
			log.error("SessionService ISessionSvcLogOnUserErrorFaultFaultMessage Block"
					+ e.getMessage());
			logOnUserResponse.setStatus(e.getFaultInfo().getType().get(0));
			
			//logOnUserResponse.setUserToken = null;
			
		} catch (Error e) {
			log.error("SessionService Error Block" + e.getMessage());
			ErrorHandler.handleError(e);
		} catch (Exception e) {
			log.error("SessionService Exception Block" + e.getMessage());
			if (e.getMessage().toString()
					.contains(ERefillConstants.STATUS_INVALID_USER_PASSWORD)) {
				logOnUserResponse
						.setStatus(ERefillConstants.STATUS_INVALID_USER_PASSWORD);
			} else if (e.getMessage().toString()
					.contains(ERefillConstants.STATUS_MINOR_USER)) {
				logOnUserResponse.setStatus(ERefillConstants.STATUS_MINOR_USER);
			} else {
				ErrorHandler.handleException(e);
			}
		}
		return logOnUserResponse;
	}

	public String emailValid(
			com.lcl.erefill.core.common.entity.UserToken userToken,
			final String name) {
		String username = name;
		String emailvalid = "";
		try {
			com.lcl.erefill.core.common.entity.UserToken token = performAgentLogin();
			Holder<UserToken> tokenHolder = prepareSessionTokenHolder(token);
			long startTime = System.currentTimeMillis();
			EmailReturnStatus EmailReturnStatus = getSessionService()
					.emailValid(tokenHolder, username);
			log.info(ERefillConstants.EXTERNAL_SRVC_EMAIL_VALID + "|"
					+ CommonUtils.executionTime(startTime));
			userToken.setStatus(tokenHolder.value.getStatus().get(0));
			userToken.setToken(CommonUtils.byteArrayAsString(tokenHolder.value
					.getToken().getValue()));
			EEmailReturnCode eEmailReturnCode = EmailReturnStatus.getCode();
			emailvalid = eEmailReturnCode.value();
		} catch (ISessionSvcEmailValidErrorFaultFaultMessage e) {
			userToken.setStatus(e.getFaultInfo().getUserToken().getValue()
					.getStatus().get(0));
			userToken.setToken(CommonUtils.byteArrayAsString(e.getFaultInfo()
					.getUserToken().getValue().getToken().getValue()));
			log.error(e.getMessage(), e);
			emailvalid = e.getMessage();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			ErrorHandler.handleException(e);
		} catch (Error e) {
			log.error(e.getMessage(), e);
			ErrorHandler.handleError(e);
		}
		return emailvalid;
	}

	public com.lcl.erefill.core.common.entity.UserToken performAgentLogin() {
		/*String agentUserName = ERefillConfigService.AGENT_USERNAME;
		String agentUserPassword = ERefillConfigService.AGENT_PASSWORD;*/
		try {
			User user = new User();
			user.setUserName(propertyUtil.getAgentUser());
			user.setPassword(propertyUtil.getAgentPassword());
			long startTime = System.currentTimeMillis();
			UserToken token = getSessionService().logOn(user, null);
			log.info(ERefillConstants.EXTERNAL_SRVC_LOGON + "|"
					+ CommonUtils.executionTime(startTime));

			com.lcl.erefill.core.common.entity.UserToken userToken = new com.lcl.erefill.core.common.entity.UserToken();
			userToken.setStatus(token.getStatus().get(0));
			userToken.setToken(CommonUtils.byteArrayAsString(token.getToken()
					.getValue()));
			return userToken;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			ErrorHandler.handleException(e);
		} catch (Error e) {
			log.error(e.getMessage(), e);
			ErrorHandler.handleError(e);
		}
		return null;
	}

	public PasswordReminder getPasswordReminder(final String username) {

		User user = null;
		PasswordReminder ePasswordReminder = null;
		try {
			if (null != username) {
				user = new User();
				user.setUserName(username);
				ePasswordReminder = new PasswordReminder();
				com.lcl.erefill.generated.telus.session.rxassystlib_contracts.PasswordReminder passwordReminder;
				long startTime = System.currentTimeMillis();
				passwordReminder = getSessionService()
						.getPasswordReminder(user);
				log.info(ERefillConstants.EXTERNAL_SRVC_GET_PWD_REMINDER + "|"
						+ CommonUtils.executionTime(startTime));
				JAXBElement<ArrayOfstring> answers = passwordReminder
						.getAnswers();
				JAXBElement<ArrayOfstring> questions = passwordReminder
						.getQuestions();
				ePasswordReminder.setAnswers(answers.getValue().getString());
				ePasswordReminder
						.setQuestions(questions.getValue().getString());
				// Added fix for the defect # 289 start
				log.info("updating the questions with ISO format");
				List<String> oldStrQues = ePasswordReminder.getQuestions();
				List<String> currStrQues = new ArrayList<String>();
				for (String question : oldStrQues) {
					currStrQues.add(CommonUtils
							.formatStringInISO885915(question));
				}
				ePasswordReminder.setQuestions(currStrQues);

			}
		} catch (ISessionSvcGetPasswordReminderErrorFaultFaultMessage e) {
			log.error(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			ErrorHandler.handleException(e);
		} catch (Error e) {
			log.error(e.getMessage(), e);
			ErrorHandler.handleError(e);
		}
		return ePasswordReminder;
	}

	public String sendPassword(final String userName, final String secQuestion,
			final String secAnswer, final int choice) {
		String sendPasswordValid = "valid";
		try {
			// short index = 0;
			List<String> eAnswers = null;
			PasswordReminder ePasswordReminder = getPasswordReminder(userName);

			eAnswers = Arrays.asList(new String[] { secAnswer });
			JAXBElement<String> identifier = new JAXBElement<String>(
					new QName(
							"http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data",
							"Identifier"), String.class,
					PasswordRecovery.class, userName);
			ArrayOfstring quesions = new ArrayOfstring();
			quesions.getString().addAll(ePasswordReminder.getQuestions());

			ArrayOfstring answers = new ArrayOfstring();
			eAnswers = CommonUtils.getSecAnswerAsList(secAnswer, choice);
			answers.getString().addAll(eAnswers);
			JAXBElement<ArrayOfstring> stringQuestion = new JAXBElement<ArrayOfstring>(
					new QName(
							"http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data",
							"Questions"), ArrayOfstring.class,
					PasswordRecovery.class, quesions);
			JAXBElement<ArrayOfstring> stringAnswers = new JAXBElement<ArrayOfstring>(
					new QName(
							"http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data",
							"Answers"), ArrayOfstring.class,
					PasswordRecovery.class, answers);
			PasswordRecovery recoverPassword = new PasswordRecovery();
			recoverPassword.setIdentifier(identifier);
			recoverPassword.setAnswerIndex((short) choice);
			recoverPassword.setAnswers(stringAnswers);
			recoverPassword.setQuestions(stringQuestion);
			long startTime = System.currentTimeMillis();
			getSessionService().sendPassword(recoverPassword);
			log.info(ERefillConstants.EXTERNAL_SRVC_SEND_PWD + "|"
					+ CommonUtils.executionTime(startTime));
		} catch (ISessionSvcSendPasswordErrorFaultFaultMessage e) {
			sendPasswordValid = e.getMessage();
			log.error(e.getMessage());

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			sendPasswordValid = e.getMessage();
			ErrorHandler.handleException(e);
		} catch (Error e) {
			log.error(e.getMessage(), e);
			ErrorHandler.handleError(e);
		}
		return sendPasswordValid;
	}

	public ChangeMyAccountPasswordResponse changeResetPassword(
			com.lcl.erefill.core.common.entity.UserToken userToken,
			final String newPassword) {

		ChangeMyAccountPasswordResponse changeAccountPassword = new ChangeMyAccountPasswordResponse();
		String status = "Ok";

		try {

			changeAccountPassword = changePassword(userToken, newPassword,
					null, false);
			return changeAccountPassword;

		} catch (ISessionSvcChangePasswordErrorFaultFaultMessage e) {
			if (e.getFaultInfo().getType().get(0)
					.equals("eInvalidUserPassword")) {
				status = "eInvalidUserPassword";
				changeAccountPassword.setChangePasswordStatus(status);
			}
			userToken.setStatus(e.getFaultInfo().getUserToken().getValue()
					.getStatus().get(0));
			userToken.setToken(CommonUtils.byteArrayAsString(e.getFaultInfo()
					.getUserToken().getValue().getToken().getValue()));
			log.error(e.getMessage(), e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			ErrorHandler.handleException(e);
		} catch (Error e) {
			log.error(e.getMessage(), e);
			ErrorHandler.handleError(e);
		}
		changeAccountPassword.setChangePasswordStatus(status);
		return changeAccountPassword;
	}

	private ChangeMyAccountPasswordResponse changePassword(
			com.lcl.erefill.core.common.entity.UserToken token,
			final String newPassword, final String currentPassword,
			boolean isAjax)
			throws ISessionSvcChangePasswordErrorFaultFaultMessage {
		String status = null;
		ChangeMyAccountPasswordResponse changePassword = new ChangeMyAccountPasswordResponse();
		try {
			if (null != newPassword) {
				Holder<UserToken> userTokenHolder = prepareSessionTokenHolder(token);
				long startTime = System.currentTimeMillis();

				getSessionService().changePassword(userTokenHolder,
						newPassword, currentPassword);
				log.info(ERefillConstants.EXTERNAL_SRVC_CHANGE_PWD + "|"
						+ CommonUtils.executionTime(startTime));
				status = userTokenHolder.value.getStatus().get(0);
				changePassword.setChangePasswordStatus(status);
				token.setStatus(status);
				token.setToken(CommonUtils
						.byteArrayAsString(userTokenHolder.value.getToken()
								.getValue()));
				changePassword.setUserToken(token);
			}
		} catch (ISessionSvcChangePasswordErrorFaultFaultMessage e) {
			log.error(e.getMessage());
			changePassword.setChangePasswordStatus(e.getFaultInfo().getType()
					.get(0));
			token.setStatus(e.getFaultInfo().getUserToken().getValue()
					.getStatus().get(0));
			token.setToken(CommonUtils.byteArrayAsString(e.getFaultInfo()
					.getUserToken().getValue().getToken().getValue()));
			changePassword.setUserToken(token);
			// throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			if (isAjax) {
				if (e.getCause() instanceof ERefillBusinessException) {
					ERefillBusinessException invalidUserExc = (ERefillBusinessException) e
							.getCause();
					token.setStatus(ERefillConstants.STATUS_INVALID_USER_PASSWORD);
					token.setToken(invalidUserExc.getUserToken().getToken());
					changePassword
							.setChangePasswordStatus(ERefillConstants.STATUS_INVALID_USER_PASSWORD);
					changePassword.setUserToken(token);
				} else {
					throw new ERefillApplicationException(e);
				}
			} else
				ErrorHandler.handleException(e);
		} catch (Error e) {
			log.error(e.getMessage(), e);
			if (isAjax)
				throw new ERefillApplicationException(e);
			else
				ErrorHandler.handleError(e);
		}
		return changePassword;
	}

	private ChangeMyAccountPasswordResponse changePassword(
			com.lcl.erefill.core.common.entity.UserToken token,
			final String newPassword, boolean isAjax, String page)
			throws ISessionSvcChangePasswordErrorFaultFaultMessage {
		String status = null;
		ChangeMyAccountPasswordResponse changePassword = new ChangeMyAccountPasswordResponse();
		try {
			if (null != newPassword) {
				Holder<UserToken> userTokenHolder = prepareSessionTokenHolder(token);
				long startTime = System.currentTimeMillis();
				String oldPassword = null;
				getSessionService().changePassword(userTokenHolder,
						newPassword, oldPassword);
				log.info(ERefillConstants.EXTERNAL_SRVC_CHANGE_PWD + "|"
						+ CommonUtils.executionTime(startTime));
				status = userTokenHolder.value.getStatus().get(0);
				changePassword.setChangePasswordStatus(status);
				token.setStatus(status);
				token.setToken(CommonUtils
						.byteArrayAsString(userTokenHolder.value.getToken()
								.getValue()));
				changePassword.setUserToken(token);

			}
		} catch (Exception e) {

			log.error(e.getMessage(), e);

			if (e.getCause() instanceof ERefillBusinessException) {
				ERefillBusinessException be = (ERefillBusinessException) e
						.getCause();
				log.error(be.getMessage());
				if (be.getMessage().toString().contains("eInvalidUserPassword")) {
					status = "eInvalidUserPassword";
					changePassword.setChangePasswordStatus(status);
				}
				if (be.getUserToken() != null) {
					changePassword.setUserToken(be.getUserToken());
				}
			} else if (isAjax) {
				throw new ERefillApplicationException(e);
				// else if (e.getCause() instanceof
				// InvalidUserPasswordException) {
				// InvalidUserPasswordException invalidUserExc =
				// (InvalidUserPasswordException) e
				// .getCause();
				// if (null != invalidUserExc) {
				// changePassword.setStatus(invalidUserExc.getStatus());
				// changePassword.setToken(invalidUserExc.getToken());
				// changePassword
				// .setChangePasswordStatus("eInvalidUserPassword");
				// }
			} else
				ErrorHandler.handleException(e);
		} catch (Error e) {
			log.error(e.getMessage(), e);
			if (isAjax)
				throw new ERefillApplicationException(e);
			else
				ErrorHandler.handleError(e);
		}
		return changePassword;
	}

	public UpdatePreferencesResponse updatePreferences(
			com.lcl.erefill.core.common.entity.UserToken userToken,
			ArrayOfAccountPreference arrayOfAccountPreference) {

		UpdatePreferencesResponse updatePref = new UpdatePreferencesResponse();
		String status = null;
		try {
			Holder<UserToken> userTokenHolder = prepareSessionTokenHolder(userToken);
			long startTime = System.currentTimeMillis();
			getSessionService().updatePreferences(userTokenHolder,
					arrayOfAccountPreference);
			log.info(ERefillConstants.EXTERNAL_SRVC_UPDATEPREFERENCES + "|"
					+ CommonUtils.executionTime(startTime));
			status = userTokenHolder.value.getStatus().get(0);
			userToken.setStatus(status);
			userToken.setToken(CommonUtils
					.byteArrayAsString(userTokenHolder.value.getToken()
							.getValue()));
			updatePref.setUserToken(userToken);
			updatePref.setResponseStatus(status);
		} catch (ISessionSvcUpdatePreferencesErrorFaultFaultMessage e) {
			log.error(e.getMessage());
			status = e.getFaultInfo().getType().get(0);
			userToken.setStatus(status);
			userToken.setToken(CommonUtils.byteArrayAsString(e.getFaultInfo()
					.getUserToken().getValue().getToken().getValue()));
			updatePref.setUserToken(userToken);
			updatePref.setResponseStatus(status);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			updatePref.setResponseStatus("Error");
		} catch (Error e) {
			log.error(e.getMessage(), e);
			updatePref.setResponseStatus("Error");
		}
		return updatePref;
	}

	/**
	 * unsubscribe
	 * 
	 * @param userToken
	 * @param isEmail
	 * @param isPhone
	 * @return
	 */
	public Map<String, String> unsubscribe(
			com.lcl.erefill.core.common.entity.UserToken userToken,
			Boolean isEmail, Boolean isPhone) {

		Map<String, String> unsubscribedMap = new HashMap<String, String>();
		String status = null;
		try {
			Holder<UserToken> userTokenHolder = prepareSessionTokenHolder(userToken);
			long startTime = System.currentTimeMillis();
			getSessionService().unsubscribeCommunication(userTokenHolder,
					isEmail, isPhone);
			log.info(ERefillConstants.EXTERNAL_SRVC_UNSUBSCRIBE + "|"
					+ CommonUtils.executionTime(startTime));
			status = userTokenHolder.value.getStatus().get(0);
			userToken.setStatus(status);
			userToken.setToken(CommonUtils
					.byteArrayAsString(userTokenHolder.value.getToken()
							.getValue()));
			unsubscribedMap.put("status", status);
			unsubscribedMap.put("token", userToken.getToken());

		} catch (ISessionSvcUnsubscribeCommunicationErrorFaultFaultMessage e) {
			log.error(e.getMessage());
			userToken.setStatus("Error");
			userToken.setToken(CommonUtils.byteArrayAsString(e.getFaultInfo()
					.getUserToken().getValue().getToken().getValue()));
			unsubscribedMap.put("status", "Error");
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			unsubscribedMap.put("status", "Error");
		} catch (Error e) {
			log.error(e.getMessage(), e);
			unsubscribedMap.put("status", "Error");
		}
		return unsubscribedMap;
	}

	public AddAccountAliasResponse addAccountAlias(
			com.lcl.erefill.core.common.entity.UserToken userToken,
			final String alias) {
		String status = "Ok";
		AddAccountAliasResponse addAccountAliasResponse = new AddAccountAliasResponse();
		try {
			Holder<UserToken> userTokenHolder = prepareSessionTokenHolder(userToken);
			long startTime = System.currentTimeMillis();
			getSessionService().addAccountAlias(alias, userTokenHolder);
			log.info(ERefillConstants.EXTERNAL_SRVC_ADD_ACCOUNT_ALIASES + "|"
					+ CommonUtils.executionTime(startTime));
			addAccountAliasResponse.setRegUserStatus(userTokenHolder.value
					.getStatus().get(0));
			userToken.setStatus(userTokenHolder.value.getStatus().get(0));
			userToken.setToken(CommonUtils
					.byteArrayAsString(userTokenHolder.value.getToken()
							.getValue()));
			addAccountAliasResponse.setUserToken(userToken);
		} catch (ISessionSvcAddAccountAliasErrorFaultFaultMessage e) {
			log.error(e.getMessage());
			if (null != e.getFaultInfo() && null != e.getFaultInfo().getType()
					&& null != e.getFaultInfo().getType().get(0)) {
				if ("eInvalidArguments".equalsIgnoreCase(e.getFaultInfo()
						.getType().get(0)))
					addAccountAliasResponse.setRegUserStatus(e.getFaultInfo()
							.getType().get(0));
			}
			ERefillToken eRefToken = new ERefillToken(e.getFaultInfo());
			userToken.setStatus(eRefToken.getStatus().get(0));
			userToken.setToken(CommonUtils.byteArrayAsString(eRefToken
					.getToken().getValue()));
			addAccountAliasResponse.setUserToken(userToken);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			ErrorHandler.handleException(e);
		} catch (Error e) {
			log.error(e.getMessage(), e);
			ErrorHandler.handleError(e);
		}
		addAccountAliasResponse.setAddStatus(status);
		return addAccountAliasResponse;
	}

	/**
	 * getUserRole
	 * 
	 * @param userToken
	 * @return
	 */
	public UserAccountGroup getUserRole(
			com.lcl.erefill.core.common.entity.UserToken userToken) {
		Holder<UserToken> userTokenHolder = prepareSessionTokenHolder(userToken);
		UserAccountGroup userAccountGroup = new UserAccountGroup();
		try {
			UserAccountsGroup accountsGroup = getSessionService().getUserRole(
					userTokenHolder);
			if(null != userToken){
			userToken.setStatus(userTokenHolder.value.getStatus().get(0));
			userToken.setToken(CommonUtils.byteArrayAsString(userTokenHolder.value.getToken().getValue()));
			}
			userAccountGroup.setUserToken(userToken);
			userAccountGroup.setUserRole(accountsGroup.getGroup().value());
		} catch (ISessionSvcGetUserRoleErrorFaultFaultMessage e) {
			if(null != userToken){
			userToken.setStatus(e.getFaultInfo().getUserToken().getValue().getStatus().get(0));
			userToken.setToken(CommonUtils.byteArrayAsString(e.getFaultInfo().getUserToken().getValue().getToken().getValue()));
			}
			userAccountGroup.setUserToken(userToken);
			log.error(e.getMessage(), e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			ErrorHandler.handleException(e);
		} catch (Error e) {
			log.error(e.getMessage(), e);
			ErrorHandler.handleError(e);
		}
		return userAccountGroup;
	}

	public ChangeMyAccountPasswordResponse changeRegistrationPassword(
			com.lcl.erefill.core.common.entity.UserToken userToken,
			final String newPassword, String page) {

		ChangeMyAccountPasswordResponse changePassword = new ChangeMyAccountPasswordResponse();
		try {
			changePassword = changePassword(userToken, newPassword, false, page);
			return changePassword;
		} catch (ISessionSvcChangePasswordErrorFaultFaultMessage e) {
			userToken.setStatus(e.getFaultInfo().getUserToken().getValue()
					.getStatus().get(0));
			userToken.setToken(CommonUtils.byteArrayAsString(e.getFaultInfo()
					.getUserToken().getValue().getToken().getValue()));
			log.error(e.getMessage(), e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			ErrorHandler.handleException(e);
		} catch (Error e) {
			log.error(e.getMessage(), e);
			ErrorHandler.handleError(e);
		}
		return changePassword;
	}

	public String confirmEmail(final String id,
			com.lcl.erefill.core.common.entity.UserToken userToken) {
		String code = null;
		try {
			Holder<UserToken> userTokenHolder = prepareSessionTokenHolder(userToken);
			long startTime = System.currentTimeMillis();
			ConfirmEmailReturnCode returnCode = getSessionService()
					.confirmEmail(userTokenHolder, id);
			log.info(ERefillConstants.EXTERNAL_SRVC_CONFIRM_EMAIL + "|"
					+ CommonUtils.executionTime(startTime));
			code = returnCode.getCode().value();
			log.info("Code: " + code);
		} catch (ISessionSvcConfirmEmailErrorFaultFaultMessage e) {
			log.error(e.getMessage());
			userToken.setStatus(e.getFaultInfo().getUserToken().getValue()
					.getStatus().get(0));
			userToken.setToken(CommonUtils.byteArrayAsString(e.getFaultInfo()
					.getUserToken().getValue().getToken().getValue()));
			if(e.getMessage().equalsIgnoreCase(ERefillConstants.STATUS_INVALID_ARGUMENTS)){
				code=EConfirmEmailReturnCode.INVALIDKEY.toString();
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			ErrorHandler.handleException(e);
		} catch (Error e) {
			log.error(e.getMessage(), e);
			ErrorHandler.handleError(e);
		}
		return code;
	}

	public UpdatePreferencesResponse verifyIdentity(
			com.lcl.erefill.core.common.entity.UserToken userToken,
			final String month, final String day, final String year,
			final String userName) {
		UpdatePreferencesResponse updatePreferencesResponse = new UpdatePreferencesResponse();
		updatePreferencesResponse.setResponseStatus("false");
		Holder<UserToken> userTokenHolder = prepareSessionTokenHolder(userToken);
		Holder<Boolean> valid = new Holder<Boolean>();
		Holder<VerifyIdentityReason> verifyIdentityReason = new Holder<VerifyIdentityReason>();
		verifyIdentityReason.value = new VerifyIdentityReason();
		try {
			valid.value = Boolean.FALSE;
			VerifyUserInputs verifications = new VerifyUserInputs();
			VerifyUserInput input = new VerifyUserInput();
			input.setField(EPatientVerification.BIRTH_DATE);
			StringBuffer dateOfBirth = new StringBuffer().append(month)
					.append("/").append(day).append("/").append(year);
			QName valQName = new QName(
					"http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data",
					"Value");
			JAXBElement<String> dobElement = new JAXBElement<String>(valQName,
					String.class, dateOfBirth.toString());
			input.setValue(dobElement);
			verifications.getVerifyUserInput().add(input);
			long startTime = System.currentTimeMillis();
			getSessionService().verifyIdentity(userTokenHolder, userName,
					verifications, valid, verifyIdentityReason);
			userToken.setStatus(userTokenHolder.value.getStatus().get(0));
			userToken.setToken(CommonUtils
					.byteArrayAsString(userTokenHolder.value.getToken()
							.getValue()));
			log.info(ERefillConstants.EXTERNAL_SRVC_VERIFY_IDENTITY + "|"
					+ CommonUtils.executionTime(startTime));
			if (valid.value) {
				updatePreferencesResponse.setResponseStatus("true");
			} else if ("mismatch".equalsIgnoreCase(verifyIdentityReason.value
					.getIdentityReason().value())) {
				updatePreferencesResponse.setResponseStatus("mismatch");
			}
		} catch (ISessionSvcVerifyIdentityErrorFaultFaultMessage e) {
			log.error(e.getMessage());
			if (null != e.getMessage()
					&& e.getMessage().equals("eAccountLocked")) {
				updatePreferencesResponse.setResponseStatus("eAccountLocked");
			}
			if(e.getFaultInfo().getUserToken()!=null){
				if(e.getFaultInfo().getUserToken().getValue()!=null){
				userToken.setStatus(e.getFaultInfo().getUserToken().getValue()
						.getStatus().get(0));
				userToken.setToken(CommonUtils.byteArrayAsString(e.getFaultInfo()
						.getUserToken().getValue().getToken().getValue()));
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			updatePreferencesResponse.setResponseStatus("error");
		} catch (Error e) {
			log.error(e.getMessage(), e);
			updatePreferencesResponse.setResponseStatus("error");
		} finally {
			updatePreferencesResponse.setUserToken(userToken);
		}

		log.debug("UpdatePreferencesResponse : "
				+ updatePreferencesResponse.toString());
		return updatePreferencesResponse;
	}

	public void logoff(com.lcl.erefill.core.common.entity.UserToken userToken,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			Holder<UserToken> userTokenHolder = prepareSessionTokenHolder(userToken);
			long startTime = System.currentTimeMillis();
			getSessionService().logOff(userTokenHolder.value);
			log.info(ERefillConstants.EXTERNAL_SRVC_LOGOFF + "|"
					+ CommonUtils.executionTime(startTime));
		} catch (ISessionSvcLogOffErrorFaultFaultMessage e) {
			log.error(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			// ErrorHandler.handleException(request, response, e);
		} catch (Error e) {
			log.error(e.getMessage(), e);
			// ErrorHandler.handleError(request, response, e);
		}
	}

	public Map<String, String> getEmailStatus(
			com.lcl.erefill.core.common.entity.UserToken userToken,
			String patientOID) {
		Map<String, String> mailid_status = new HashMap<String, String>();
		try {
			Holder<UserToken> userTokenHolder = prepareSessionTokenHolder(userToken);
			Holder<String> emailHolder = new Holder<String>();
			String email = "";
			emailHolder.value = email;
			Holder<EmailReturnStatus> emailStatusholder = new Holder<EmailReturnStatus>();
			EmailReturnStatus emailReturnStatus = new EmailReturnStatus();
			emailStatusholder.value = emailReturnStatus;
			long startTime = System.currentTimeMillis();
			getSessionService().getConfirmEmail(userTokenHolder, "",
					emailHolder, emailStatusholder);
			log.info("getConfirmEmail" + "|"
					+ CommonUtils.executionTime(startTime));

			EEmailReturnCode eEmailReturnCode = emailStatusholder.value
					.getCode();
			mailid_status.put("status", eEmailReturnCode.value());
			mailid_status.put("mailid", emailHolder.value);
			mailid_status.put("token_status", userTokenHolder.value.getStatus()
					.get(0));
			mailid_status.put("token_value", CommonUtils
					.byteArrayAsString(userTokenHolder.value.getToken()
							.getValue()));
			userToken.setStatus(userTokenHolder.value.getStatus().get(0));
			userToken.setToken(CommonUtils
					.byteArrayAsString(userTokenHolder.value.getToken()
							.getValue()));
		} catch (ISessionSvcGetConfirmEmailErrorFaultFaultMessage e) {
			userToken.setStatus(e.getFaultInfo().getUserToken().getValue()
					.getStatus().get(0));
			userToken.setToken(CommonUtils.byteArrayAsString(e.getFaultInfo()
					.getUserToken().getValue().getToken().getValue()));
			log.error(e.getMessage(), e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			ErrorHandler.handleException(e);
		} catch (Error e) {
			log.error(e.getMessage(), e);
			ErrorHandler.handleError(e);
		}
		return mailid_status;
	}

	/**
	 * getPhoneNumberStatus
	 * 
	 * @param userToken
	 * @return
	 */
	public Map<String, String> getPhoneNumberStatus(
			com.lcl.erefill.core.common.entity.UserToken userToken) {
		Map<String, String> phn_status = new HashMap<String, String>();
		try {
			String username = "";
			Holder<UserToken> userTokenHolder = prepareSessionTokenHolder(userToken);
			Holder<String> phnHolder = new Holder<String>();
			phnHolder.value = null;
			Holder<Integer> phnStatusholder = new Holder<Integer>();
			phnStatusholder.value = null;
			long startTime = System.currentTimeMillis();
			getSessionService().getConfirmMobilePhoneNumber(userTokenHolder,
					username, phnHolder, phnStatusholder);
			log.info("getPhoneNumberStatus: "
					+ CommonUtils.executionTime(startTime));
			userToken.setStatus(userTokenHolder.value.getStatus().get(0));
			userToken.setToken(CommonUtils
					.byteArrayAsString(userTokenHolder.value.getToken()
							.getValue()));
			phn_status.put("token_status", userTokenHolder.value.getStatus()
					.get(0));
			phn_status.put("token_value", CommonUtils
					.byteArrayAsString(userTokenHolder.value.getToken()
							.getValue()));
			phn_status.put("status", phnStatusholder.value.toString());
			phn_status.put("phnno", phnHolder.value);
		} catch (ISessionSvcGetConfirmMobilePhoneNumberErrorFaultFaultMessage e) {
			log.error(e.getMessage());
			phn_status.put("status", "Error");
			phn_status.put(
					"token_value",
					CommonUtils.byteArrayAsString(e.getFaultInfo()
							.getUserToken().getValue().getToken().getValue()));
			phn_status.put("token_status", e.getFaultInfo().getUserToken()
					.getValue().getStatus().get(0));
			return phn_status;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			phn_status.put("status", "Error");
			// ErrorHandler.handleException(e);
			return phn_status;

		} catch (Error e) {
			log.error(e.getMessage(), e);
			phn_status.put("status", "Error");
			// ErrorHandler.handleError(e);
			return phn_status;

		}
		return phn_status;
	}

	public AccountPreferenceVO listPreferences(
			com.lcl.erefill.core.common.entity.UserToken userToken) {
		ArrayOfAccountPreference arrayOfAccountPreference = null;
		AccountPreferenceVO accountPreferenceVO = new AccountPreferenceVO();
		try {
			Holder<UserToken> userTokenHolder = prepareSessionTokenHolder(userToken);
			long startTime = System.currentTimeMillis();
			arrayOfAccountPreference = getSessionService().listPreferences(
					userTokenHolder);
			log.info(ERefillConstants.EXTERNAL_SRVC_LISTPREFERENCES + "|"
					+ CommonUtils.executionTime(startTime));
			userToken.setStatus(userTokenHolder.value.getStatus().get(0));
			userToken.setToken(CommonUtils
					.byteArrayAsString(userTokenHolder.value.getToken()
							.getValue()));
			List<AccountPreference> accountPreferences = arrayOfAccountPreference
					.getAccountPreference();
			List<String> pagedata = new ArrayList<String>();
			Map<AccountPreferenceEAccountPreferenceType, String> data = new HashMap<AccountPreferenceEAccountPreferenceType, String>();
			for (AccountPreference accountPreference : accountPreferences) {
				String value = accountPreference.getValue();
				data.put(accountPreference.getType(),
						accountPreference.getValue());
				pagedata.add(value);

			}
			accountPreferenceVO
					.setSecurityQuestion1(data
							.get(AccountPreferenceEAccountPreferenceType.PASWORD_RECOVERY_QUESTION_1));
			accountPreferenceVO
					.setSecurityQuestion2(data
							.get(AccountPreferenceEAccountPreferenceType.PASWORD_RECOVERY_QUESTION_2));
			accountPreferenceVO
					.setSecurityQuestion3(data
							.get(AccountPreferenceEAccountPreferenceType.PASWORD_RECOVERY_QUESTION_3));
			accountPreferenceVO
					.setSecurityQuestion_Answer1(data
							.get(AccountPreferenceEAccountPreferenceType.PASWORD_RECOVERY_QUESTION_ANSWER_1));
			accountPreferenceVO
					.setSecurityQuestion_Answer2(data
							.get(AccountPreferenceEAccountPreferenceType.PASWORD_RECOVERY_QUESTION_ANSWER_2));
			accountPreferenceVO
					.setSecurityQuestion_Answer3(data
							.get(AccountPreferenceEAccountPreferenceType.PASWORD_RECOVERY_QUESTION_ANSWER_3));
			accountPreferenceVO
					.setMobilePhoneNo(data
							.get(AccountPreferenceEAccountPreferenceType.MOBILE_PHONE_NUMBER));
			accountPreferenceVO.setMailId(data
					.get(AccountPreferenceEAccountPreferenceType.EMAIL));
		} catch (ISessionSvcListPreferencesErrorFaultFaultMessage e) {
			userToken.setStatus(e.getFaultInfo().getUserToken().getValue()
					.getStatus().get(0));
			userToken.setToken(CommonUtils.byteArrayAsString(e.getFaultInfo()
					.getUserToken().getValue().getToken().getValue()));
			log.error(e.getMessage(), e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			ErrorHandler.handleException(e);
		} catch (Error e) {
			log.error(e.getMessage(), e);
			ErrorHandler.handleError(e);
		}
		return accountPreferenceVO;
	}

	public Account getCurrentAccount(
			com.lcl.erefill.core.common.entity.UserToken userToken) {
		Account eAccount = null;
		try {
			eAccount = new Account();
			Holder<UserToken> userTokenHolder = prepareSessionTokenHolder(userToken);
			if (null != userTokenHolder) {
				long startTime = System.currentTimeMillis();
				com.lcl.erefill.generated.telus.session.rxassystlib.Account account = getSessionService()
						.getCurrentAccount(userTokenHolder);
				log.info(ERefillConstants.EXTERNAL_SRVC_GET_CURRENT_ACCOUNT
						+ "|" + CommonUtils.executionTime(startTime));
				userToken.setStatus(userTokenHolder.value.getStatus().get(0));
				userToken.setToken(CommonUtils
						.byteArrayAsString(userTokenHolder.value.getToken()
								.getValue()));

				if (null != account) {
					eAccount.setFirstName(account.getFirstName());
					eAccount.setUserName(account.getUserName());
					eAccount.setLastName(account.getLastName());
					eAccount.setUsertoken(userToken);
				}
			}
		} catch (ISessionSvcGetCurrentAccountErrorFaultFaultMessage e) {
			userToken.setStatus(e.getFaultInfo().getUserToken().getValue()
					.getStatus().get(0));
			userToken.setToken(CommonUtils.byteArrayAsString(e.getFaultInfo()
					.getUserToken().getValue().getToken().getValue()));
			log.error(e.getMessage(), e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			ErrorHandler.handleException(e);
		} catch (Error e) {
			log.error(e.getMessage(), e);
			ErrorHandler.handleError(e);
		}
		return eAccount;
	}

	public ChangeMyAccountPasswordResponse changeMyAccountPassword(
			com.lcl.erefill.core.common.entity.UserToken userToken,
			final String newPassword, final String currentPassword) {

		ChangeMyAccountPasswordResponse changePasswordResponse = new ChangeMyAccountPasswordResponse();

		try {

			changePasswordResponse = changePassword(userToken, newPassword,
					currentPassword, true);
			return changePasswordResponse;
		} catch (ISessionSvcChangePasswordErrorFaultFaultMessage e) {
			changePasswordResponse.setChangePasswordStatus(e.getFaultInfo()
					.getType().get(0));
			userToken.setStatus(e.getFaultInfo().getUserToken().getValue()
					.getStatus().get(0));
			userToken.setToken(CommonUtils.byteArrayAsString(e.getFaultInfo()
					.getUserToken().getValue().getToken().getValue()));
			changePasswordResponse.setUserToken(userToken);
			log.error(e.getMessage(), e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			if (e.getCause() instanceof ERefillBusinessException) {
				ERefillBusinessException eRefillBusinessException = (ERefillBusinessException) e
						.getCause();
				userToken
						.setStatus(ERefillConstants.STATUS_INVALID_USER_PASSWORD);
				userToken.setToken(eRefillBusinessException.getUserToken()
						.getToken());
				changePasswordResponse
						.setChangePasswordStatus(ERefillConstants.STATUS_INVALID_USER_PASSWORD);
				changePasswordResponse.setUserToken(userToken);
			} else {
				throw new ERefillApplicationException(e);
			}
		} catch (Error e) {
			log.error(e.getMessage(), e);
			// ErrorHandler.handleError(request, response, e);
			throw new ERefillApplicationException(e);
		}
		return changePasswordResponse;
	}

	public AccountAliasResponse getAccountAlias(
			com.lcl.erefill.core.common.entity.UserToken userToken) {
		AccountAliases accountAliases = null;
		AccountAliasResponse accountAliasResponse = new AccountAliasResponse();
		String currentAlias = "";
		try {

			Holder<UserToken> userTokenHolder = null;
			userTokenHolder = prepareSessionTokenHolder(userToken);
			long startTime = System.currentTimeMillis();
			accountAliases = getSessionService().getAccountAliases(
					userTokenHolder, null);
			log.info(ERefillConstants.EXTERNAL_SRVC_GET_ACCOUNT_ALIASES + "|"
					+ CommonUtils.executionTime(startTime));
			userToken.setStatus(userTokenHolder.value.getStatus().get(0));
			userToken.setToken(CommonUtils
					.byteArrayAsString(userTokenHolder.value.getToken()
							.getValue()));
			accountAliasResponse.setUserToken(userToken);

			if (accountAliases != null) {
				List<AccountAlias> accountAlias = accountAliases
						.getAccountAlias();
				if (!CommonUtils.isNullOrEmpty(accountAlias)) {
					AccountAlias accountAlias2 = accountAlias.get(accountAlias
							.size() - 1);
					currentAlias = accountAlias2.getAlias();
					accountAliasResponse.setUserName(currentAlias);
				}
			}
		} catch (ISessionSvcGetAccountAliasesErrorFaultFaultMessage e) {
			userToken.setStatus(e.getFaultInfo().getUserToken().getValue()
					.getStatus().get(0));
			userToken.setToken(CommonUtils.byteArrayAsString(e.getFaultInfo()
					.getUserToken().getValue().getToken().getValue()));
			accountAliasResponse.setUserToken(userToken);
			log.error(e.getMessage(), e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			ErrorHandler.handleException(e);
		} catch (Error e) {
			log.error(e.getMessage(), e);
			ErrorHandler.handleError(e);
		}
		return accountAliasResponse;
	}

	public List<String> getListSecurityQuestions(String strQuestions) {
		List<String> arrRetVal = new ArrayList<String>();
		if (null != strQuestions && !strQuestions.isEmpty()) {
			List<String> tempList = Arrays.asList(strQuestions.split(";:;"));
			for (String strTemp : tempList) {
				strTemp = CommonUtils.formatStringInUTF8(strTemp);
				arrRetVal.add(strTemp);
			}
		}
		return arrRetVal;
	}

	public UpdateAccountAliasResponse updateAccountAlias(
			com.lcl.erefill.core.common.entity.UserToken userToken,
			final String newUsername) {
		String status = null;
		UpdateAccountAliasResponse updateAcct = new UpdateAccountAliasResponse();

		try {
			Holder<UserToken> userTokenHolder = null;
			String currentAlias2 = null;

			userTokenHolder = prepareSessionTokenHolder(userToken);
			long startTime = System.currentTimeMillis();
			AccountAliases accountAliases = getSessionService()
					.getAccountAliases(userTokenHolder, null);
			log.info(ERefillConstants.EXTERNAL_SRVC_UPDATE_ACCOUNT_ALIASES
					+ "|" + CommonUtils.executionTime(startTime));
			updateAcct.setStatus(status);

			if (accountAliases != null) {
				List<AccountAlias> accountAlias = accountAliases
						.getAccountAlias();
				if (accountAlias.size() != 0) {
					AccountAlias accountAlias2 = accountAlias.get(0);
					currentAlias2 = accountAlias2.getAlias();

					getSessionService().updateAccountAlias(userTokenHolder,
							currentAlias2, newUsername);
					status = userTokenHolder.value.getStatus().get(0);
					updateAcct.setStatus(status);
					userToken.setStatus(status);
					userToken.setToken(CommonUtils
							.byteArrayAsString(userTokenHolder.value.getToken()
									.getValue()));
					updateAcct.setUserToken(userToken);
				}

			}
		} catch (ISessionSvcGetAccountAliasesErrorFaultFaultMessage e) {
			status = e.getFaultInfo().getType().get(0);
			userToken.setStatus(e.getFaultInfo().getUserToken().getValue()
					.getStatus().get(0));
			userToken.setToken(CommonUtils.byteArrayAsString(e.getFaultInfo()
					.getUserToken().getValue().getToken().getValue()));
			// updateAcct.setStatus("Ok");
			updateAcct.setUserToken(userToken);
			log.error(e.getMessage());
		} catch (ISessionSvcUpdateAccountAliasErrorFaultFaultMessage e) {
			status = e.getFaultInfo().getType().get(0);
			// updateAcct.setStatus("Ok");
			userToken.setStatus(e.getFaultInfo().getUserToken().getValue()
					.getStatus().get(0));
			userToken.setToken(CommonUtils.byteArrayAsString(e.getFaultInfo()
					.getUserToken().getValue().getToken().getValue()));
			updateAcct.setUserToken(userToken);
			updateAcct.setStatus(status);
			log.error(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			ErrorHandler.handleException(e);
		} catch (Error e) {
			log.error(e.getMessage(), e);
			ErrorHandler.handleError(e);
		}

		return updateAcct;
	}

	public UpdatePasswordReminderResponse updatePasswordReminder(
			com.lcl.erefill.core.common.entity.UserToken userToken,
			final List<String> eQuestions, final List<String> eAnswers,
			final String email) {
		Holder<UserToken> userTokenHolder = prepareSessionTokenHolder(userToken);
		String status = "Ok";
		UpdatePasswordReminderResponse updatePasswordReminderReponse = new UpdatePasswordReminderResponse();
		try {
			if (null != eQuestions && null != eAnswers
					&& null != userTokenHolder) {
				ArrayOfstring quesions = new ArrayOfstring();
				quesions.getString().addAll(eQuestions);
				ArrayOfstring Stringanswers = new ArrayOfstring();
				Stringanswers.getString().addAll(eAnswers);
				JAXBElement<ArrayOfstring> questions = new JAXBElement<ArrayOfstring>(
						new QName(
								"http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data",
								"Questions"), ArrayOfstring.class,
						PasswordRecovery.class, quesions);
				JAXBElement<ArrayOfstring> answers = new JAXBElement<ArrayOfstring>(
						new QName(
								"http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data",
								"Answers"), ArrayOfstring.class,
						PasswordRecovery.class, Stringanswers);

				com.lcl.erefill.generated.telus.session.rxassystlib_contracts.PasswordReminder reminder = new com.lcl.erefill.generated.telus.session.rxassystlib_contracts.PasswordReminder();
				if (null != reminder) {
					reminder.setAnswers(answers);
					reminder.setQuestions(questions);
					long startTime = System.currentTimeMillis();
					getSessionService().updatePasswordReminder(userTokenHolder,
							reminder, email, null);
					log.info(ERefillConstants.EXTERNAL_SRVC_UPDATE_PWD_REMINDER
							+ "|" + CommonUtils.executionTime(startTime));
				}

				userToken.setStatus(userTokenHolder.value.getStatus().get(0));
				userToken.setToken(CommonUtils
						.byteArrayAsString(userTokenHolder.value.getToken()
								.getValue()));
				updatePasswordReminderReponse.setUserToken(userToken);
			}
		} catch (ISessionSvcUpdatePasswordReminderErrorFaultFaultMessage e) {
			userToken.setStatus(e.getFaultInfo().getUserToken().getValue()
					.getStatus().get(0));
			userToken.setToken(CommonUtils.byteArrayAsString(e.getFaultInfo()
					.getUserToken().getValue().getToken().getValue()));
			log.error(e.getMessage(), e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			ErrorHandler.handleException(e);
		} catch (Error e) {
			log.error(e.getMessage(), e);
			ErrorHandler.handleError(e);
		}
		updatePasswordReminderReponse.setUpdateResponse(status);
		return updatePasswordReminderReponse;
	}
}
