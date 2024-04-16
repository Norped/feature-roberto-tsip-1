package com.urlnavigator.api.exception;

/**
 * This class includes error messages for general and client specific errors For
 * corresponding Error codes see {@link ApiErrorCodes}
 */
public class ApiErrorMessages {

  private ApiErrorMessages() {
    // private constructor since this is a constants class
  }

  public static final String CLIENT_ID_IS_REQUIRED = "Client Id is required.";
  public static final String CLIENT_NAME_IS_REQUIRED = "Client Name is required.";
  public static final String CLIENT_REGION_IS_REQUIRED = "Client Region is required.";
  public static final String CLIENT_REGION_ID_IS_REQUIRED = "Client Region Id is required.";
  public static final String CLIENT_REGION_NAME_IS_REQUIRED = "Client Region Name is required.";
  public static final String CLIENT_LEGACY_REGION_ID_IS_REQUIRED = "Client Legacy Region Id is required.";
  public static final String PARAMETERS_ARE_REQUIRED = "Please provide the parameters.";
  public static final String ID_NOT_FOUND = "Identification provided doesn't exist.";
  public static final String CANDIDATE_ID_IS_REQUIRED = "Candidate Id is required.";
  public static final String REGION_ID_IS_REQUIRED = "Region id is required";
  public static final String REGION_NOT_EXIST = "The provided region doesn't exist.";
  public static final String NO_TRANSCRIPT_FOUND_FOR_CANDIDATE = "No transcript found for the candidate provided.";
  public static final String NO_DATA_FOUND = "No data found";
  public static final String INVALID_PARAMETERS = "Invalid parameter values.";
  public static final String FAILED_TO_DELETE = "Failed to delete a record";
  public static final String CANDIDATE_LEGACY_REGION_REQUIRED_FIELDS = "One of the fields is required: Candidate ID, Legacy Candidate ID, Legacy Region ID.";
  public static final String CANDIDATE_LEGACY_REGION_ID_IS_REQUIRED = "Candidate Legacy Region ID is required.";
  public static final String CANDIDATE_LEGACY_REGION_CANDIDATE_ID_IS_REQUIRED = "CandidateID is required.";
  public static final String RETAKE_RULE_ID_IS_REQUIRED = "Retake Rule Id is required.";
  public static final String REGION_ID_INVALID = "Invalid Region ID provided.";
  public static final String REMINDER_RULE_ID_IS_REQUIRED = "Reminder Rule Id is required.";
  public static final String REMINDER_HISTORY_ID_IS_REQUIRED = "Reminder History Id is required.";
  public static final String CREDENTIAL_ID_IS_REQUIRED = "CredentialID is required.";
  public static final String EXAM_ID_IS_REQUIRED = "[Exam ID] is required.";
  public static final String PRODUCT_ID_IS_REQUIRED = "[Product ID] is required.";
  public static final String RELEASE_ID_IS_REQUIRED = "[Release ID] is required.";
  public static final String START_DATE_IS_REQUIRED = "[Start Date] is required.";
  public static final String START_DATE_IS_INVALID = "[Start Date] is invalid. ";
  public static final String END_DATE_IS_REQUIRED = "[End Date] is required..";
  public static final String END_DATE_IS_INVALID = "[End Date] is invalid.";
  public static final String START_DATE_LESSER_END_DATE_MESSAGE = "[Start Date] should be lesser than/equal to [End Date].";
  public static final String EXAM_PRODUCT_ID_IS_REQUIRED = "[Exam Product ID] is required.";
  public static final String EXAM_PRODUCT_ID_NOT_FOUND = "Exam Product ID is not found.";

  public static final String CERTIFICATION_ID_REQUIRED = "Certification Id is required.";
  public static final String CERTIFICATION_PATHWAY_ID_REQUIRED = "Certification Pathway ID is required.";
  public static final String CERTIFICATION_PATHWAY_DETAIL_ID_REQUIRED = "Certification Pathway Detail ID is required.";
  public static final String EXAM_GROUP_ID_REQUIRED = "Exam Group Id is required.";

  public static final String EXAM_GROUP_DETAIL_ID_REQUIRED = "Exam Group Detail Id is required.";
  public static final String EXAM_NAME_REQUIRED = "Exam Name is required.";
  public static final String EXAM_ID_REQUIRED = "Exam Id is required.";
  public static final String EXAM_TYPE_REQUIRED = "Exam type is required.";
  public static final String EXAM_TYPE_IS_INVALID = "Exam type is invalid.";
  
  public static final String URL_IS_EMPTY = "Url is empty.";
  public static final String URL_IS_NOT_FOUND = "Url is not found.";
  public static final String URL_ID_MUST_NUMERIC = "Url Id must numeric.";
  public static final String URL_ID_ = "Url Id must numeric."; 
  
  public static final String URL_INVALID_DELETE = "Url Id not found; deletion not possible."; 
  
  
  
  
}
