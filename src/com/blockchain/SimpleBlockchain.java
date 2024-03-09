package com.blockchain;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class SimpleBlockchain {
    public static void main(String[] args) {
        try {
            SimpleBlock simpleBlock = new SimpleBlock();
            StringBuffer completeBlockChain = new StringBuffer();
            String blockChain = simpleBlock.createHash(0, getZonedDateTime(), "This is block number 0", "0");
            completeBlockChain.append(blockChain);
            int totalNumOfBlocks = 15;
            String previousHash = blockChain;
            for (int i = 1; i <= totalNumOfBlocks; i++) {
                blockChain = simpleBlock.createHash(i, getZonedDateTime(), "This is block number " + i, previousHash);
                completeBlockChain.append(blockChain);
                previousHash = blockChain;
            }
            System.out.println("Complete BlockChain:" + completeBlockChain);
        } catch(NoSuchAlgorithmException nsae) {
            nsae.printStackTrace();
        }
    }
    private static ZonedDateTime getZonedDateTime() {
        return ZonedDateTime.of(LocalDate.now(), LocalTime.now(), ZoneId.systemDefault());
    }
}

