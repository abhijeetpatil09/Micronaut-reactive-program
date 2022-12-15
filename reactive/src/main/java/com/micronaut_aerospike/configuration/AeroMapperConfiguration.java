package com.micronaut_aerospike.configuration;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.policy.ClientPolicy;
import com.aerospike.client.policy.RecordExistsAction;
import com.aerospike.client.reactor.AerospikeReactorClient;
import com.aerospike.client.reactor.IAerospikeReactorClient;
import com.aerospike.mapper.tools.AeroMapper;
import com.aerospike.mapper.tools.ReactiveAeroMapper;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class AeroMapperConfiguration {
    @Inject
    AerospikeConfiguration aerospikeConfiguration;


//    ReactiveAeroMapper mapper = null;
//
//    @PostConstruct
//    public void aerospikeClient() {
//        ClientPolicy policy = new ClientPolicy();
//        policy.readPolicyDefault.socketTimeout = 50;
//        policy.readPolicyDefault.totalTimeout = 110;
//        policy.readPolicyDefault.sleepBetweenRetries = 10;
//        policy.writePolicyDefault.socketTimeout = 200;
//        policy.writePolicyDefault.totalTimeout = 450;
//        policy.writePolicyDefault.sleepBetweenRetries = 50;
//        policy.writePolicyDefault.recordExistsAction=RecordExistsAction.CREATE_ONLY;
//
//        AerospikeClient client = new AerospikeClient(policy, "127.0.0.1", 3000) ;
//
//        IAerospikeReactorClient IAerospikeReactorClient = new AerospikeReactorClient(client, policy.eventLoops);
//
//        mapper = new ReactiveAeroMapper.Builder(IAerospikeReactorClient).build();
//    }
//
//    public ReactiveAeroMapper getMapper() {
//
//        return this.mapper;
//    }
    AeroMapper mapper = null;

    @PostConstruct
    public void aerospikeClient() {
        ClientPolicy policy = new ClientPolicy();

        AerospikeClient client = new AerospikeClient(policy, aerospikeConfiguration.getHost(), aerospikeConfiguration.getPort());
        mapper = new AeroMapper.Builder(client).build();
    }

    public AeroMapper getMapper() {

        return this.mapper;
    }

}
