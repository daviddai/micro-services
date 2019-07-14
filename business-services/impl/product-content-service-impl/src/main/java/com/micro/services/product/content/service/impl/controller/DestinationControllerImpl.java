package com.micro.services.product.content.service.impl.controller;

import com.micro.services.product.content.service.controller.DestinationController;
import com.micro.services.product.content.service.model.TopDestination;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/destination")
public class DestinationControllerImpl implements DestinationController {

    @Override
    @GetMapping(value = "/top")
    public List<TopDestination> getTopDestinations() {
        List<String> topDestinationNames = Arrays.asList(
                "Tokyo", "Sydney", "New York", "Hong Kong",
                "London", "Las Vegas", "Singapore", "Shanghai",
                "Kyoto", "Osaka", "Beijing", "Bali",
                "Phuket", "Zurich", "Forssa", "Rome"
        );

        List<String> topDestinationImageUrls = Arrays.asList(
                "https://i2.wp.com/passionpassport.com/wp-content/uploads/2018/01/tokyo-instagram-guide-Fred-Chen.jpg?fit=800%2C599&ssl=1",
                "https://lonelyplanetimages.imgix.net/mastheads/65830387.jpg?sharp=10&vib=20&w=1200",
                "https://lonelyplanetimages.imgix.net/mastheads/GettyImages-538096543_medium.jpg?sharp=10&vib=20&w=1200",
                "https://media.timeout.com/images/103812417/image.jpg",
                "https://cdn.londonandpartners.com/visit/general-london/areas/river/76709-640x360-houses-of-parliament-and-london-eye-on-thames-from-above-640.jpg",
                "http://res.cloudinary.com/simpleview/image/upload/v1497480003/clients/lasvegas/strip_b86ddbea-3add-4995-b449-ac85d700b027.jpg",
                "https://smemagazine.asia/en/wp-content/uploads/2019/06/20190610-SME-Website-Singapore-Among-Easiest-Business-Places-Image.jpg",
                "https://singularityhub.com/wp-content/uploads/2018/03/innovators-city-guide-shanghai-china-skyline-night-214399000.jpg",
                "https://photos.smugmug.com/Kyoto/Honeymoon-in-Kyoto/i-LdmsJPZ/0/26b66d84/XL/shutterstock_626644001-XL.jpg",
                "https://www.jnto.go.jp/ph/spot-activity/wp-content/uploads/sites/2/2018/10/OC-Cherry-Blossom-01.jpg",
                "https://www.tripsavvy.com/thmb/GO2tYbWXqp9vtSJefM8vxFpaL0k=/960x0/filters:no_upscale():max_bytes(150000):strip_icc()/GettyImages-4894349271-59e8e9a8d088c000119103c6.jpg",
                "http://static.asiawebdirect.com/m/bangkok/portals/bali-indonesia-com/homepage/first-time-bali/pagePropertiesImage/bali-first-time.jpg.jpg",
                "https://dak95nwic4sny.cloudfront.net/73/thailand-40155070-1508147260-ImageGalleryLightboxLarge.jpg",
                "https://btcnn.com/wp-content/uploads/2018/11/swiss-bank.jpg",
                "https://www.flashpack.com/wp-content/uploads/2018/10/Glamping-Finland-Northern-Lights-Tour-1.jpg",
                "https://www.fodors.com/wp-content/uploads/2018/10/HERO_UltimateRome_Hero_shutterstock789412159.jpg"
        );

        List<TopDestination> topDestinations = new ArrayList<>();

        for (int i = 0; i < topDestinationNames.size(); ++i) {
            topDestinations.add(new TopDestination(topDestinationNames.get(i), topDestinationImageUrls.get(i)));
        }

        return topDestinations;
    }
}
