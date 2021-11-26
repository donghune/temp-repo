package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.annotations.BelongsTo;
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

/** This is an auto generated class representing the Comment type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Comments")
public final class Comment implements Model {
  public static final QueryField ID = field("Comment", "id");
  public static final QueryField TEXT = field("Comment", "text");
  public static final QueryField AUTHOR = field("Comment", "commentAuthorId");
  public static final QueryField POST = field("Comment", "commentPostId");
  public static final QueryField POST_COMMENTS_ID = field("Comment", "postCommentsId");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String", isRequired = true) String text;
  private final @ModelField(targetType="User") @BelongsTo(targetName = "commentAuthorId", type = User.class) User author;
  private final @ModelField(targetType="Post") @BelongsTo(targetName = "commentPostId", type = Post.class) Post post;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  private final @ModelField(targetType="ID") String postCommentsId;
  public String getId() {
      return id;
  }
  
  public String getText() {
      return text;
  }
  
  public User getAuthor() {
      return author;
  }
  
  public Post getPost() {
      return post;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  public String getPostCommentsId() {
      return postCommentsId;
  }
  
  private Comment(String id, String text, User author, Post post, String postCommentsId) {
    this.id = id;
    this.text = text;
    this.author = author;
    this.post = post;
    this.postCommentsId = postCommentsId;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Comment comment = (Comment) obj;
      return ObjectsCompat.equals(getId(), comment.getId()) &&
              ObjectsCompat.equals(getText(), comment.getText()) &&
              ObjectsCompat.equals(getAuthor(), comment.getAuthor()) &&
              ObjectsCompat.equals(getPost(), comment.getPost()) &&
              ObjectsCompat.equals(getCreatedAt(), comment.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), comment.getUpdatedAt()) &&
              ObjectsCompat.equals(getPostCommentsId(), comment.getPostCommentsId());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getText())
      .append(getAuthor())
      .append(getPost())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .append(getPostCommentsId())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Comment {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("text=" + String.valueOf(getText()) + ", ")
      .append("author=" + String.valueOf(getAuthor()) + ", ")
      .append("post=" + String.valueOf(getPost()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()) + ", ")
      .append("postCommentsId=" + String.valueOf(getPostCommentsId()))
      .append("}")
      .toString();
  }
  
  public static TextStep builder() {
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
  public static Comment justId(String id) {
    try {
      UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
    } catch (Exception exception) {
      throw new IllegalArgumentException(
              "Model IDs must be unique in the format of UUID. This method is for creating instances " +
              "of an existing object with only its ID field for sending as a mutation parameter. When " +
              "creating a new object, use the standard builder method and leave the ID field blank."
      );
    }
    return new Comment(
      id,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      text,
      author,
      post,
      postCommentsId);
  }
  public interface TextStep {
    BuildStep text(String text);
  }
  

  public interface BuildStep {
    Comment build();
    BuildStep id(String id) throws IllegalArgumentException;
    BuildStep author(User author);
    BuildStep post(Post post);
    BuildStep postCommentsId(String postCommentsId);
  }
  

  public static class Builder implements TextStep, BuildStep {
    private String id;
    private String text;
    private User author;
    private Post post;
    private String postCommentsId;
    @Override
     public Comment build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Comment(
          id,
          text,
          author,
          post,
          postCommentsId);
    }
    
    @Override
     public BuildStep text(String text) {
        Objects.requireNonNull(text);
        this.text = text;
        return this;
    }
    
    @Override
     public BuildStep author(User author) {
        this.author = author;
        return this;
    }
    
    @Override
     public BuildStep post(Post post) {
        this.post = post;
        return this;
    }
    
    @Override
     public BuildStep postCommentsId(String postCommentsId) {
        this.postCommentsId = postCommentsId;
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
    private CopyOfBuilder(String id, String text, User author, Post post, String postCommentsId) {
      super.id(id);
      super.text(text)
        .author(author)
        .post(post)
        .postCommentsId(postCommentsId);
    }
    
    @Override
     public CopyOfBuilder text(String text) {
      return (CopyOfBuilder) super.text(text);
    }
    
    @Override
     public CopyOfBuilder author(User author) {
      return (CopyOfBuilder) super.author(author);
    }
    
    @Override
     public CopyOfBuilder post(Post post) {
      return (CopyOfBuilder) super.post(post);
    }
    
    @Override
     public CopyOfBuilder postCommentsId(String postCommentsId) {
      return (CopyOfBuilder) super.postCommentsId(postCommentsId);
    }
  }
  
}
