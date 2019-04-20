package com.wilson.elston.babycare;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class Information extends AppCompatActivity {

    TextView info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        info=(TextView) findViewById(R.id.info);

        Intent intent=getIntent();
        String value=intent.getStringExtra("val");

        switch (value)
        {
            case "Handling a new born":
            {
                info.setText("\n" +
                        "If you haven't spent a lot of time around newborns, their fragility may be intimidating. Here are a few basics to remember:\n" +
                        "\n" +
                        "    Wash your hands (or use a hand sanitizer) before handling your baby. Newborns don't have a strong immune system yet, so they're at risk for infection. Make sure that everyone who handles your baby has clean hands.\n" +
                        "    Support your baby's head and neck. Cradle the head when carrying your baby and support the head when carrying the baby upright or when you lay your baby down.\n" +
                        "    Never shake your newborn, whether in play or in frustration. Shaking can cause bleeding in the brain and even death. If you need to wake your infant, don't do it by shaking — instead, tickle your baby's feet or blow gently on a cheek.\n" +
                        "    Make sure your baby is securely fastened into the carrier, stroller, or car seat. Limit any activity that could be too rough or bouncy.\n" +
                        "    Remember that your newborn is not ready for rough play, such as being jiggled on the knee or thrown in the air.");
                break;
            }
            case "Bonding & Soothing":
            {
                info.setText(R.string.Bonding_Soothing);
                break;
            }
            case "Bathing Basics":
            {
                info.setText("\n" +
                        "\n" +
                        "You should give your baby a sponge bath until:\n" +
                        "\n" +
                        "    the umbilical cord falls off and the navel heals completely (1–4 weeks)\n" +
                        "    the circumcision heals (1–2 weeks)\n" +
                        "\n" +
                        "A bath two or three times a week in the first year is fine. More frequent bathing may be drying to the skin.\n" +
                        "\n" +
                        "Have these items ready before bathing your baby:\n" +
                        "\n" +
                        "    a soft, clean washcloth\n" +
                        "    mild, unscented baby soap and shampoo\n" +
                        "    a soft brush to stimulate the baby's scalp\n" +
                        "    towels or blankets\n" +
                        "    a clean diaper\n" +
                        "    clean clothes\n" +
                        "\n" +
                        "Sponge baths. For a sponge bath, select a safe, flat surface (such as a changing table, floor, or counter) in a warm room. Fill a sink, if nearby, or bowl with warm (not hot!) water. Undress your baby and wrap him or her in a towel. Wipe your infant's eyes with a washcloth (or a clean cotton ball) dampened with water only, starting with one eye and wiping from the inner corner to the outer corner. Use a clean corner of the washcloth or another cotton ball to wash the other eye. Clean your baby's nose and ears with the damp washcloth. Then wet the cloth again and, using a little soap, wash his or her face gently and pat it dry.\n" +
                        "\n" +
                        "Next, using baby shampoo, create a lather and gently wash your baby's head and rinse. Using a wet cloth and soap, gently wash the rest of the baby, paying special attention to creases under the arms, behind the ears, around the neck, and in the genital area. Once you have washed those areas, make sure they are dry and then diaper and dress your baby.\n" +
                        "\n" +
                        "Tub baths. When your baby is ready for tub baths, the first baths should be gentle and brief. If he or she becomes upset, go back to sponge baths for a week or two, then try the bath again.\n" +
                        "\n" +
                        "In addition to the supplies listed above, add:\n" +
                        "\n" +
                        "    an infant tub with 2 to 3 inches of warm — not hot! — water (to test the water temperature, feel the water with the inside of your elbow or wrist). An infant tub is a plastic tub that can fit in the bathtub; it's a better size for babies and makes bathing easier to manage.\n" +
                        "\n" +
                        "Undress your baby and then place him or her in the water immediately, in a warm room, to prevent chills. Make sure the water in the tub is no more than 2 to 3 inches deep, and that the water is no longer running in the tub. Use one of your hands to support the head and the other hand to guide the baby in feet-first. Speaking gently, slowly lower your baby up to the chest into the tub.\n" +
                        "\n" +
                        "Use a washcloth to wash his or her face and hair. Gently massage your baby's scalp with the pads of your fingers or a soft baby hairbrush, including the area over the fontanelles (soft spots) on the top of the head. When you rinse the soap or shampoo from your baby's head, cup your hand across the forehead so the suds run toward the sides and soap doesn't get into the eyes. Gently wash the rest of your baby's body with water and a small amount of soap.\n" +
                        "\n" +
                        "Throughout the bath, regularly pour water gently over your baby's body so he or she doesn't get cold. After the bath, wrap your baby in a towel immediately, making sure to cover his or her head. Baby towels with hoods are great for keeping a freshly washed baby warm.\n" +
                        "\n" +
                        "While bathing your infant, never leave the baby alone. If you need to leave the bathroom, wrap the baby in a towel and take him or her with you");
                break;
            }
            case "Feeding Baby":
            {
                info.setText("\n" +
                        "Whether feeding your newborn by breast or a bottle, you may be stumped as to how often to do so. Generally, it's recommended that babies be fed on demand — whenever they seem hungry. Your baby may cue you by crying, putting fingers in his or her mouth, or making sucking noises.\n" +
                        "\n" +
                        "A newborn baby needs to be fed every 2 to 3 hours. If you're breastfeeding, give your baby the chance to nurse about 10–15 minutes at each breast. If you're formula-feeding, your baby will most likely take about 2–3 ounces (60–90 milliliters) at each feeding.\n" +
                        "\n" +
                        "Some newborns may need to be awakened every few hours to make sure they get enough to eat. Call your baby's doctor if you need to wake your newborn often or if your baby doesn't seem interested in eating or sucking.\n" +
                        "\n" +
                        "If you're formula-feeding, you can easily monitor if your baby is getting enough to eat, but if you're breastfeeding, it can be a little trickier. If your baby seems satisfied, produces about six wet diapers and several stools a day, sleeps well, and is gaining weight regularly, then he or she is probably eating enough.\n" +
                        "\n" +
                        "Another good way to tell if your baby is getting milk is to notice if your breasts feel full before feeding your baby and less full after feeding. Talk to your doctor if you have concerns about your child's growth or feeding schedule.\n" +
                        "\n" +
                        "Babies often swallow air during feedings, which can make them fussy. To help prevent this, burp your baby often. Try burping your baby every 2–3 ounces (60–90 milliliters) if you bottle-feed, and each time you switch breasts if you breastfeed.\n" +
                        "\n" +
                        "If your baby tends to be gassy, has gastroesophageal reflux, or seems fussy during feeding, try burping your little one after every ounce during bottle-feeding or every 5 minutes during breastfeeding.\n" +
                        "\n" +
                        "Try these burping tips:\n" +
                        "\n" +
                        "    Hold your baby upright with his or her head on your shoulder. Support your baby's head and back while gently patting the back with your other hand.\n" +
                        "    Sit your baby on your lap. Support your baby's chest and head with one hand by cradling your baby's chin in the palm of your hand and resting the heel of your hand on your baby's chest (be careful to grip your baby's chin — not throat). Use the other hand to gently pat your baby's back.\n" +
                        "    Lay your baby face-down on your lap. Support your baby's head, making sure it's higher than his or her chest, and gently pat or rub his or her back.\n" +
                        "\n" +
                        "If your baby doesn't burp after a few minutes, change the baby's position and try burping for another few minutes before feeding again. Always burp your baby when feeding time is over, then keep him or her in an upright position for at least 10–15 minutes to avoid spitting up.");
                break;
            }
            case "Sleeping Basics":
            {
                info.setText("\n" +
                        "As a new parent, you may be surprised to learn that your newborn, who seems to need you every minute of the day, actually sleeps about 16 hours or more!\n" +
                        "\n" +
                        "Newborns typically sleep for periods of 2–4 hours. Don't expect yours to sleep through the night — the digestive system of babies is so small that they need nourishment every few hours and should be awakened if they haven't been fed for 4 hours (or more often if your doctor is concerned about weight gain).\n" +
                        "\n" +
                        "When can you expect your baby to sleep through the night? Many babies sleep through the night (between 6–8 hours) at 3 months of age, but if yours doesn't, it's not a cause for concern. Like adults, babies must develop their own sleep patterns and cycles, so if your newborn is gaining weight and appears healthy, don't despair if he or she hasn't slept through the night at 3 months.\n" +
                        "\n" +
                        "It's important to always place babies on their backs to sleep to reduce the risk of SIDS (sudden infant death syndrome). Other safe sleeping practices include: not using blankets, quilts, sheepskins, stuffed animals, and pillows in the crib or bassinet (these can suffocate a baby); and sharing a bedroom (but not a bed) with the parents for the first 6 months to 1 year. Also be sure to alternate the position of your baby's head from night to night (first right, then left, and so on) to prevent the development of a flat spot on one side of the head.\n" +
                        "\n" +
                        "Many newborns have their days and nights \"mixed up.\" They tend to be more awake and alert at night, and more sleepy during the day. One way to help them is to keep stimulation at night to a minimum. Keep the lights low, such as by using a nightlight. Reserve talking and playing with your baby for the daytime. When your baby wakes up during the day, try to keep him or her awake a little longer by talking and playing.");
                break;
            }

            default:
                info.setText("NULL");
        }


    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
            {
                onBackPressed();
                return true;
            }
        }
        return true;

    }
}
