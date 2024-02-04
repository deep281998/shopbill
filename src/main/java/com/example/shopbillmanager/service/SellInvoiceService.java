package com.example.shopbillmanager.service;

import com.example.shopbillmanager.dtos.reqdtos.SellInvoiceItemreqdtos;
import com.example.shopbillmanager.model.Customer;
import com.example.shopbillmanager.model.Item;
import com.example.shopbillmanager.model.Sellinvoice;
import com.example.shopbillmanager.repository.CustomerRepository;
import com.example.shopbillmanager.repository.ItemRepository;
import com.example.shopbillmanager.repository.SellInvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SellInvoiceService {

    @Autowired
    SellInvoiceRepository sellInvoiceRepository;
    @Autowired
    ItemRepository itemRepository;

    @Autowired
    CustomerRepository customerRepository;


    public ResponseEntity<String> addbill(String customer, List<SellInvoiceItemreqdtos> items) {
        Optional<Customer> optionalCustomer = customerRepository.getcustomerfrommobile(customer);
        if(optionalCustomer.isPresent()){
            Customer presentcustomer = optionalCustomer.get();
            List<Item> singlebillitem = new ArrayList<>();
            List<Integer> quantity = new ArrayList<>();
            double total  = 0.0;
            for(SellInvoiceItemreqdtos tobesold : items){
                Optional<Item> optionalItem = itemRepository.findById(tobesold.getId());
                if(optionalItem.isPresent()){
                    Item item = optionalItem.get();
                    Item sellingitem = Item.builder()
                                       .id(item.getId())
                            .name(item.getName())
                            .price(item.getPrice())
                            .packaging(item.getPackaging())
                            .pur_price(item.getPur_price())
                            .quantity(tobesold.getQuantity())
                            .build();
                    quantity.add(tobesold.getQuantity());
                    System.out.println(sellingitem.getQuantity() + "without saving");
                    item.setQuantity(item.getQuantity() - sellingitem.getQuantity());
                    itemRepository.save(item);
                    total += sellingitem.getPrice() * sellingitem.getQuantity();
                    singlebillitem.add(sellingitem);
                }
            }
            Sellinvoice sellinvoice = new Sellinvoice();
            sellinvoice.setItems(singlebillitem);
            sellinvoice.setQuant(quantity);
            sellinvoice.setTransactiontype(null);
            sellinvoice.setCustomer(presentcustomer);
            sellinvoice.setAmount(total);
            sellinvoice.setDateofpayment(null);

            sellInvoiceRepository.save(sellinvoice);

            List<Sellinvoice> sellinvoiceList = presentcustomer.getSellinvoices();
            sellinvoiceList.add(sellinvoice);
            presentcustomer.setSellinvoices(sellinvoiceList);
            customerRepository.save(presentcustomer);
            List<Item> itemList = sellinvoice.getItems();
            System.out.println(itemList.get(0).getQuantity());
        }
        return ResponseEntity.ok("Success");
    }

    public ResponseEntity<String> removeitem(int billid, String itemid) {
        Optional<Sellinvoice> optionalSellinvoice = sellInvoiceRepository.findById(billid);
        Optional<Item> optionalItem = itemRepository.findById(itemid);
        System.out.println(optionalItem.get().getId() + "orginal id");
        if (optionalItem.isPresent() && optionalSellinvoice.isPresent()) {
            Item originalItem = optionalItem.get();
            System.out.println(originalItem.getQuantity() + "original item id quantity");
            Sellinvoice sellinvoiceindb = optionalSellinvoice.get();

            List<Item> itemListinsell = sellinvoiceindb.getItems();
            int idx = itemListinsell.indexOf(originalItem);
            Item sellinvoiceitem = new Item();
            for(Item sellitem : itemListinsell){
                if(sellitem.getId().equals(itemid)){
                    sellinvoiceitem = sellitem;
                }
            }
            if (sellinvoiceitem != null) {
                System.out.println(sellinvoiceitem.getQuantity() + "quantity which is present in sellinvoice");
                // Create a detached copy of the item in the sell invoice
                Item detachedCopy = Item.builder()
                        .id(sellinvoiceitem.getId())
                        .name(sellinvoiceitem.getName())
                        .price(sellinvoiceitem.getPrice())
                        .packaging(sellinvoiceitem.getPackaging())
                        .pur_price(sellinvoiceitem.getPur_price())
                        .quantity(sellinvoiceitem.getQuantity())
                        .build();

                // Update the original item's quantity in stock
                originalItem.setQuantity(originalItem.getQuantity() + sellinvoiceindb.getQuant().get(idx));
                itemRepository.save(originalItem);

                // Update the total amount and remove the item from the sell invoice
                double total = sellinvoiceindb.getAmount() - (detachedCopy.getPrice() * sellinvoiceindb.getQuant().get(idx));
                itemListinsell.remove(sellinvoiceitem);

                // Update the sell invoice
                sellinvoiceindb.setItems(itemListinsell);
                sellinvoiceindb.setAmount(total);
                sellInvoiceRepository.save(sellinvoiceindb);

                return ResponseEntity.ok("success");
            } else {
                return ResponseEntity.badRequest().body("Item not present in the sell invoice");
            }
        } else {
            return ResponseEntity.badRequest().body("Sell invoice or item not present");
        }
    }

    public ResponseEntity<String> additem(int billid, SellInvoiceItemreqdtos sellInvoiceItemreqdtos) {
        Optional<Sellinvoice> optionalSellinvoice = sellInvoiceRepository.findById(billid);
        Optional<Item> optionalItem = itemRepository.findById(sellInvoiceItemreqdtos.getId());
        if(optionalItem.isPresent() && optionalSellinvoice.isPresent()){
            Sellinvoice sellinvoiceindb = optionalSellinvoice.get();
            Item itemtobeadded = optionalItem.get();
            List<Integer> quantity = sellinvoiceindb.getQuant();
            List<Item> itemList = sellinvoiceindb.getItems();
            double total = sellinvoiceindb.getAmount();
            if(itemtobeadded.getQuantity() >= sellInvoiceItemreqdtos.getQuantity()){
                if(itemList.contains(itemtobeadded)){
                    int idx = itemList.indexOf(itemtobeadded);
                    int quant = quantity.get(idx);
                    quanti
                }
                else {
                    itemList.add(itemtobeadded);
                    quantity.add(sellInvoiceItemreqdtos.getQuantity());
                    total += sellInvoiceItemreqdtos.getQuantity() * itemtobeadded.getPrice();
                    sellinvoiceindb.setAmount(total);
                    sellinvoiceindb.setQuant(quantity);
                    sellinvoiceindb.setItems(itemList);
                    sellInvoiceRepository.save(sellinvoiceindb);
                    itemtobeadded.setQuantity(itemtobeadded.getQuantity() - sellInvoiceItemreqdtos.getQuantity());
                    itemRepository.save(itemtobeadded);
                    return ResponseEntity.ok("success");
                }
            }
            else {
                return ResponseEntity.badRequest().body("not enough quantity avialable");
            }
        }
        else {
            return ResponseEntity.badRequest().body("sell invoice or item not present");
        }
    }
}
