package gatherer;

import com.google.firebase.database.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardController {
    public static Card qCard;

    @RequestMapping("/card")
    public Card card(@RequestParam(value="name", defaultValue="Fireball") String name) {

        Application.database.orderByChild("name").equalTo(name).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot data : dataSnapshot.getChildren()) {
                    qCard = data.getValue(Card.class);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed.");
            }
        });

        return qCard;
    }

    @RequestMapping("/create")
    public void test(@RequestParam(value="name", defaultValue="Fireball") String name, @RequestParam(value="cost", defaultValue="4") int cost,
                     @RequestParam(value="flavor", defaultValue="Stuff") String flavor, @RequestParam(value="text", defaultValue="Deal 6 damage.") String text,
                     @RequestParam(value="type", defaultValue="8") int type, @RequestParam(value="rarity", defaultValue="0") int rarity,
                     @RequestParam(value="set", defaultValue="0") int set) {

        Application.database.push().setValue(new Card(name, cost, flavor, text, type, rarity, set));
    }
}
