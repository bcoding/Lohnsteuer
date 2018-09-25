package de.powerproject.lohnpap.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.powerproject.lohnpap.pap.Lohnsteuer;
import de.powerproject.lohnpap.pap.LohnsteuerInput;
import de.powerproject.lohnpap.pap.LohnsteuerInterface;
import de.powerproject.lohnpap.pap.LohnsteuerOutput;

@RestController
public class LohnpapController {

    @GetMapping("lohnsteuer")
    public LohnsteuerOutput getLohnsteuer(@RequestParam("taxDate") LocalDate taxDate, LohnsteuerInput input) {
        final Optional<? extends LohnsteuerInterface> pap = Lohnsteuer.getInstance(taxDate, input);
        if(pap.isPresent()) {
            return pap.get().calculate();
        }
        throw new IllegalArgumentException("");
    }

}
