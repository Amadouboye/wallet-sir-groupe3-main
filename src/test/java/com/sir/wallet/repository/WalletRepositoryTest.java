package com.sir.wallet.repository;

import com.sir.wallet.model.Wallet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class WalletRepositoryTest {
    @Autowired
    WalletRepository walletRepository;

    @Test
    void saveWallet() {
        //Given
        Wallet wallet = new Wallet(1L, "compte", 2000);
        //when
        Wallet reponseWallet = walletRepository.save(wallet);
        //then
        assertNotNull(reponseWallet);
        assertEquals(reponseWallet.getName(), wallet.getName());
    }

    @Test
    void updateWallet() {
        //Given
        Wallet wallet = walletRepository.save(new Wallet(2l, "epargne", 40000));
        //when
        wallet.setName("porte");
        wallet.setBalance(700);
        //then
        Wallet reponseUpdate = walletRepository.save(wallet);
        assertNotNull(reponseUpdate);
        assertEquals(reponseUpdate.getName(), wallet.getName());
        assertEquals(reponseUpdate.getBalance(), wallet.getBalance());
    }

    @Test
    void deleteWallet() {
        //Given and when
        Wallet wallet = walletRepository.save(new Wallet(3l, "tata", 300));
          //then
        if(walletRepository.findById(wallet.getId())!=null)
            walletRepository.delete(wallet);
    }
    @Test
    void getAllWallet(){
        //Given
        List<Wallet> wallets = new ArrayList<Wallet>();
        wallets.add(new Wallet(1L,"boubs", 150));
        wallets.add(new Wallet(2L, "Abdoulaye",1024));
        wallets.add(new Wallet(4L, "baye", 16724));
        //when
        walletRepository.saveAll(wallets);
        //then
        List<Wallet> wallets1 = (List<Wallet>) walletRepository.findAll();
        assertTrue(wallets1.size() > 2
        );

    }
}