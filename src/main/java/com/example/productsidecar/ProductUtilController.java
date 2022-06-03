package com.example.productsidecar;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/product-util/v1")
public class ProductUtilController {

    @GetMapping
    public ResponseEntity<List<ProductAdvertisement>> getTodaysAds() {
        List<ProductAdvertisement> ads = generateAds();

        return ResponseEntity.ok(ads);
    }

    private List<ProductAdvertisement> generateAds() {
        List<ProductAdvertisement> toReturn = new ArrayList<>();
        IntStream.range(1, 10).forEach(val -> {
            ProductAdvertisement ad = new ProductAdvertisement();
            ad.setHeadline(String.format("This is advertisement %d", val));
            ad.setMessage(String.format("Come and get a discounted %d!", val));
            toReturn.add(ad);
        });
        return toReturn;
    }
}
