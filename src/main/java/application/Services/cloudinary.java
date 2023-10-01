package application.Services;
import application.DTO.Case;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * The Cloudinary class provides a centralized instance of the Cloudinary client
 * for interacting with the Cloudinary service.
 */
public class cloudinary {
    public static String cloudName;
    public static String apiKey;
    public static String apiSecret;

    static {
        ResourceBundle rd = ResourceBundle.getBundle("cloudinary");
        cloudName = rd.getString("cloudinary.CLOUDINARY_CLOUD_NAME");
        apiKey = rd.getString("cloudinary.CLOUDINARY_API_KEY");
        apiSecret = rd.getString("cloudinary.CLOUDINARY_API_SECRET");

    }

    private static volatile Cloudinary cloudinary = null;

    private cloudinary() {
    }

    static {
        if (cloudinary == null) {
            synchronized (cloudinary.class) {
                if (cloudinary == null) {
                    Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                    "cloud_name", cloudName,
                            "api_key", apiKey,
                            "api_secret", apiSecret));
                }
            }
        }
    }

    /**
     * Retrieves the Cloudinary client instance.
     *
     * @return The Cloudinary client instance.
     */
    public static Cloudinary getCloudinary() {
        return cloudinary;
    }
    public static Object upload(File file, Case casee){
        try{
            Map result = cloudinary.uploader().upload(file, ObjectUtils.asMap(
                    "public_id", "MaCNSS/case"+ casee.getId()+"/"+file.getName(),
                    "overwrite", false,
                    "resource_type", "pdf"
            ));
            if (result != null){
                return result.get("secure_url");
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
