package com.mvvmdao.greendao;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END
/**
 * Entity mapped to table "USER_INFO".
 */
public class UserInfo {

    private Long id;
    /** Not-null value. */
    private String objectId;
    /** Not-null value. */
    private String username;
    /** Not-null value. */
    private String password;
    /** Not-null value. */
    private String cteatAt;

    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    public UserInfo() {
    }

    public UserInfo(Long id) {
        this.id = id;
    }

    public UserInfo(Long id, String objectId, String username, String password, String cteatAt) {
        this.id = id;
        this.objectId = objectId;
        this.username = username;
        this.password = password;
        this.cteatAt = cteatAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /** Not-null value. */
    public String getObjectId() {
        return objectId;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    /** Not-null value. */
    public String getUsername() {
        return username;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setUsername(String username) {
        this.username = username;
    }

    /** Not-null value. */
    public String getPassword() {
        return password;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setPassword(String password) {
        this.password = password;
    }

    /** Not-null value. */
    public String getCteatAt() {
        return cteatAt;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setCteatAt(String cteatAt) {
        this.cteatAt = cteatAt;
    }

    // KEEP METHODS - put your custom methods here
    // KEEP METHODS END

}
