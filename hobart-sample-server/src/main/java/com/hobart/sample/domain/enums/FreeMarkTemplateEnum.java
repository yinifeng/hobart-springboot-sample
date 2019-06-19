package com.hobart.sample.domain.enums;

/**
 * The enum Uac email template enum.
 *
 * @author paascloud.net@gmail.com
 */
public enum FreeMarkTemplateEnum {
	
	ACTIVE_USER_SUCCESS("ACTIVE_USER_SUCCESS", "注册用户-激活用户成功", "freemark/user.ftl");
	
	/**
	 * The Key.
	 */
	String key;
	/**
	 * The Subject.
	 */
	String subject;
	/**
	 * The Location.
	 */
	String location;

	FreeMarkTemplateEnum(String key, String subject, String location) {
		this.key = key;
		this.subject = subject;
		this.location = location;
	}

	/**
	 * Gets key.
	 *
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * Gets location.
	 *
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * Gets subject.
	 *
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

}
