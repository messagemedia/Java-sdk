package com.messagemedia.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class RichLink 
        implements java.io.Serializable {
    private static final long serialVersionUID = -6289764594080126008L;
    private String image;
    private String title;
    private String description;
    /** GETTER
     * The image field is used to specify the url of the media file that you want to show in the link preview. Supported file formats include png, jpeg and gif.
     */
    @JsonGetter("image")
    public String getImage ( ) { 
        return this.image;
    }
    
    /** SETTER
     * The image field is used to specify the url of the media file that you want to show in the link preview. Supported file formats include png, jpeg and gif.
     */
    @JsonSetter("image")
    public void setImage (String value) { 
        this.image = value;
    }
 
    /** GETTER
     * The (optional) title that appears on your unfurled link. Maximum 80  characters.
     */
    @JsonGetter("title")
    public String getTitle ( ) { 
        return this.title;
    }
    
    /** SETTER
     * The (optional) title that appears on your unfurled link. Maximum 80  characters.
     */
    @JsonSetter("title")
    public void setTitle (String value) { 
        this.title = value;
    }
 
    /** GETTER
     * An optional description, maximum 150 characters.
     */
    @JsonGetter("description")
    public String getDescription ( ) { 
        return this.description;
    }
    
    /** SETTER
     * An optional description, maximum 150 characters.
     */
    @JsonSetter("description")
    public void setDescription (String value) { 
        this.description = value;
    }
 
}
