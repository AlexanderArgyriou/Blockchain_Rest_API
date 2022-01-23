package com.argyriou.test;

import com.argyriou.contracts.Owner;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.DefaultGasProvider;

public class Test1 {
    public static void main(String[] args) throws Exception {
        Web3j web3 = Web3j.build( new HttpService() );
        Credentials credentials = WalletUtils.loadCredentials( "pass", "walletpath" );
        Owner contract = Owner.deploy( web3, credentials, new DefaultGasProvider() ).send();
        String owner = contract.getOwner().sendAsync().get();
        System.out.println( owner) ;
    }
}
