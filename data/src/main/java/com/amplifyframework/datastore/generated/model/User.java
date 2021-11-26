package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.temporal.Temporal;

import java.util.List;
import java.util.UUID;
import java.util.Objects;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the User type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Users")
@Index(name = "userByNickName", fields = {"nickName"})
public final class User implements Model {
  public static final QueryField ID = field("User", "id");
  public static final QueryField NICK_NAME = field("User", "nickName");
  public static final QueryField PHOTO = field("User", "photo");
  public static final QueryField EMAIL = field("User", "email");
  public static final QueryField PHONE_NUMBER = field("User", "phoneNumber");
  public static final QueryField INTRODUCTION = field("User", "introduction");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String", isRequired = true) String nickName;
  private final @ModelField(targetType="String") String photo;
  private final @ModelField(targetType="String") String email;
  private final @ModelField(targetType="String") String phoneNumber;
  private final @ModelField(targetType="String") String introduction;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String getId() {
      return id;
  }
  
  public String getNickName() {
      return nickName;
  }
  
  public String getPhoto() {
      return photo;
  }
  
  public String getEmail() {
      return email;
  }
  
  public String getPhoneNumber() {
      return phoneNumber;
  }
  
  public String getIntroduction() {
      return introduction;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private User(String id, String nickName, String photo, String email, String phoneNumber, String introduction) {
    this.id = id;
    this.nickName = nickName;
    this.photo = photo;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.introduction = introduction;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      User user = (User) obj;
      return ObjectsCompat.equals(getId(), user.getId()) &&
              ObjectsCompat.equals(getNickName(), user.getNickName()) &&
              ObjectsCompat.equals(getPhoto(), user.getPhoto()) &&
              ObjectsCompat.equals(getEmail(), user.getEmail()) &&
              ObjectsCompat.equals(getPhoneNumber(), user.getPhoneNumber()) &&
              ObjectsCompat.equals(getIntroduction(), user.getIntroduction()) &&
              ObjectsCompat.equals(getCreatedAt(), user.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), user.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getNickName())
      .append(getPhoto())
      .append(getEmail())
      .append(getPhoneNumber())
      .append(getIntroduction())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("User {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("nickName=" + String.valueOf(getNickName()) + ", ")
      .append("photo=" + String.valueOf(getPhoto()) + ", ")
      .append("email=" + String.valueOf(getEmail()) + ", ")
      .append("phoneNumber=" + String.valueOf(getPhoneNumber()) + ", ")
      .append("introduction=" + String.valueOf(getIntroduction()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static NickNameStep builder() {
      return new Builder();
  }
  
  /** 
   * WARNING: This method should not be used to build an instance of this object for a CREATE mutation.
   * This is a convenience method to return an instance of the object with only its ID populated
   * to be used in the context of a parameter in a delete mutation or referencing a foreign key
   * in a relationship.
   * @param id the id of the existing item this instance will represent
   * @return an instance of this model with only ID populated
   * @throws IllegalArgumentException Checks that ID is in the proper format
   */
  public static User justId(String id) {
    try {
      UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
    } catch (Exception exception) {
      throw new IllegalArgumentException(
              "Model IDs must be unique in the format of UUID. This method is for creating instances " +
              "of an existing object with only its ID field for sending as a mutation parameter. When " +
              "creating a new object, use the standard builder method and leave the ID field blank."
      );
    }
    return new User(
      id,
      null,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      nickName,
      photo,
      email,
      phoneNumber,
      introduction);
  }
  public interface NickNameStep {
    BuildStep nickName(String nickName);
  }
  

  public interface BuildStep {
    User build();
    BuildStep id(String id) throws IllegalArgumentException;
    BuildStep photo(String photo);
    BuildStep email(String email);
    BuildStep phoneNumber(String phoneNumber);
    BuildStep introduction(String introduction);
  }
  

  public static class Builder implements NickNameStep, BuildStep {
    private String id;
    private String nickName;
    private String photo;
    private String email;
    private String phoneNumber;
    private String introduction;
    @Override
     public User build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new User(
          id,
          nickName,
          photo,
          email,
          phoneNumber,
          introduction);
    }
    
    @Override
     public BuildStep nickName(String nickName) {
        Objects.requireNonNull(nickName);
        this.nickName = nickName;
        return this;
    }
    
    @Override
     public BuildStep photo(String photo) {
        this.photo = photo;
        return this;
    }
    
    @Override
     public BuildStep email(String email) {
        this.email = email;
        return this;
    }
    
    @Override
     public BuildStep phoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
    
    @Override
     public BuildStep introduction(String introduction) {
        this.introduction = introduction;
        return this;
    }
    
    /** 
     * WARNING: Do not set ID when creating a new object. Leave this blank and one will be auto generated for you.
     * This should only be set when referring to an already existing object.
     * @param id id
     * @return Current Builder instance, for fluent method chaining
     * @throws IllegalArgumentException Checks that ID is in the proper format
     */
    public BuildStep id(String id) throws IllegalArgumentException {
        this.id = id;
        
        try {
            UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
        } catch (Exception exception) {
          throw new IllegalArgumentException("Model IDs must be unique in the format of UUID.",
                    exception);
        }
        
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String id, String nickName, String photo, String email, String phoneNumber, String introduction) {
      super.id(id);
      super.nickName(nickName)
        .photo(photo)
        .email(email)
        .phoneNumber(phoneNumber)
        .introduction(introduction);
    }
    
    @Override
     public CopyOfBuilder nickName(String nickName) {
      return (CopyOfBuilder) super.nickName(nickName);
    }
    
    @Override
     public CopyOfBuilder photo(String photo) {
      return (CopyOfBuilder) super.photo(photo);
    }
    
    @Override
     public CopyOfBuilder email(String email) {
      return (CopyOfBuilder) super.email(email);
    }
    
    @Override
     public CopyOfBuilder phoneNumber(String phoneNumber) {
      return (CopyOfBuilder) super.phoneNumber(phoneNumber);
    }
    
    @Override
     public CopyOfBuilder introduction(String introduction) {
      return (CopyOfBuilder) super.introduction(introduction);
    }
  }
  
}
