package com.lwc.admin.info;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.Collections;



@Component
public class AppInfoContriibutor implements InfoContributor {




    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("msg","123")
                .withDetail("hello","546")
               .withDetail("wordl","789");
    }
}
