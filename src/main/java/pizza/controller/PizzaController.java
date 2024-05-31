package pizza.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

public class PizzaController {

    @FXML @Getter @Setter
    private TextField name;
    @FXML @Getter @Setter
    private TextField address;
    @FXML @Getter @Setter
    private TextField phoneNumber;
    @FXML @Getter @Setter
    private RadioButton paymentCash;
    @FXML @Getter @Setter
    private RadioButton paymentCard;


    @FXML
    public CheckBox feltetSonka;
    @FXML
    public CheckBox feltetGomba;
    @FXML
    public CheckBox feltetBacon;
    @FXML
    public CheckBox feltetKolbasz;
    @FXML
    public RadioButton meret32;
    @FXML
    public RadioButton meret45;
    @FXML
    public CheckBox feltetSajt;
    @FXML
    public CheckBox feltetCheedarsajt;
    @FXML
    public CheckBox feltetFustoltsajt;
    @FXML
    public CheckBox feltetFetasajt;
    @FXML
    public CheckBox feltetHagyma;
    @FXML
    public CheckBox feltetUborka;
    @FXML
    public CheckBox feltetOlivabogyo;
    @FXML
    public CheckBox feltetTejfol;
    @FXML
    public CheckBox feltetFokhagyma;
    @FXML
    public CheckBox feltetCsipospaprika;
    @FXML
    public CheckBox feltetKukorica;
    @FXML
    public CheckBox feltetAnanasz;
    @FXML
    public RadioButton alapParadicsom;
    @FXML
    public RadioButton alapTejfol;

    @Getter
    private PizzaOrder currentOrder = new PizzaOrder();

    @FXML
    public void initialize() {
    }

    @FXML
    public void collectOrder() {
        // Megrendelő adatai
        currentOrder.setName(name.getText());
        currentOrder.setAddress(address.getText());
        currentOrder.setPhoneNumber(phoneNumber.getText());

        // Fizetési mód
        if (paymentCash.isSelected()) {
            currentOrder.setPaymentMethod("Készpénz");
        } else if (paymentCard.isSelected()) {
            currentOrder.setPaymentMethod("Online bankkártya");
        }

        // Pizza alap
        if (alapParadicsom.isSelected()) {
            currentOrder.setBase("Paradicsomos alap");
        } else if (alapTejfol.isSelected()) {
            currentOrder.setBase("Tejfölös alap");
        }

        // Feltétek
        List<String> toppings = new ArrayList<>();
        if (feltetSonka.isSelected()) {
            toppings.add("Sonka");
        }
        if (feltetGomba.isSelected()) {
            toppings.add("Gomba");
        }
        if (feltetBacon.isSelected()) {
            toppings.add("Bacon");
        }
        if (feltetKolbasz.isSelected()) {
            toppings.add("Kolbász");
        }
        if (feltetSajt.isSelected()) {
            toppings.add("Sajt");
        }
        if (feltetCheedarsajt.isSelected()) {
            toppings.add("Cheedar sajt");
        }
        if (feltetFustoltsajt.isSelected()) {
            toppings.add("Füstölt sajt");
        }
        if (feltetFetasajt.isSelected()) {
            toppings.add("Feta sajt");
        }
        if (feltetHagyma.isSelected()) {
            toppings.add("Hagyma");
        }
        if (feltetUborka.isSelected()) {
            toppings.add("Uborka");
        }
        if (feltetOlivabogyo.isSelected()) {
            toppings.add("Olivabogyó");
        }
        if (feltetTejfol.isSelected()) {
            toppings.add("Tejföl");
        }
        if (feltetFokhagyma.isSelected()) {
            toppings.add("Fokhagyma");
        }
        if (feltetCsipospaprika.isSelected()) {
            toppings.add("Csípős paprika");
        }
        if (feltetKukorica.isSelected()) {
            toppings.add("Kukorica");
        }
        if (feltetAnanasz.isSelected()) {
            toppings.add("Ananász");
        }
        currentOrder.setToppings(toppings);

        // Méret kiválasztása
        if (meret32.isSelected()) {
            currentOrder.setSize("32 cm");
        } else if (meret45.isSelected()) {
            currentOrder.setSize("45 cm");
        }
    }

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class PizzaOrder {
        private String name;
        private String address;
        private String phoneNumber;
        private String paymentMethod;
        private String base;
        private String size;
        private List<String> toppings;
    }
}
