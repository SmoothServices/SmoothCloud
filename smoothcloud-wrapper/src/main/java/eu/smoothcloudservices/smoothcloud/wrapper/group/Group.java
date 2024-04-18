package eu.smoothcloudservices.smoothcloud.wrapper.group;

import eu.smoothcloudservices.smoothcloud.wrapper.mojang.ServerJar;
import eu.smoothcloudservices.smoothcloud.wrapper.service.Service;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Group {

    private int maxMem;
    private int post;
    private String hostAddress;
    private ArrayList<Service> maxServices;
    private ArrayList<Service> onlineServices;
    private ServerJar serverJar;

    public Group(int maxMem, int post, String hostAddress, int services, ServerJar serverJar) {
        this.maxMem = maxMem;
        this.post = post;
        this.hostAddress = hostAddress;
        this.serverJar = serverJar;
    }
}
