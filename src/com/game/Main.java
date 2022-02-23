package com.game;

import com.service.ManageAssets;
import com.service.ManageCombat;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ManageCombat manageCombat = ManageCombat.PreparerCombat();
        manageCombat.LancerCombat();
    }
}
