package com.capg.pizzapp.Form;

import lombok.Data;

public class Forms {

    @Data
    public static class UpdateUserForm {
        private String userName;
        private String userAddress;
        private String userPhoneNumber;
    }

    @Data
    public static class UpdatePizzaForm {
        private String pizzaName;
        private String pizzaDesc;
        private String pizzaType;
        private Double pizzaPrice;
    }
}
