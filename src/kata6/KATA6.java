package kata6;

import java.io.IOException;
import java.util.ArrayList;

public class KATA6 {
    
    public static void main(String[] args) throws IOException {
        String name = "DATA\\emailsfilev1.txt";
        ArrayList<Person> arrayMail = MailListReader.read(name);
        System.out.println(arrayMail.size());
        HistogramBuilder<Person>  builder = new HistogramBuilder<>(arrayMail);
        Histogram<String> domains=builder.build(new Attribute<Person,String>(){
            @Override
            public String get(Person item){
                return (item.getMail().split("@")[1]);
            }
        });
        Histogram<Character> letters = builder.build(new Attribute<Person,Character>(){
            public Character get(Person item){
                return item.getMail().charAt(0);
            }
        });   
        new HistogramDisplay(domains,"Dominios").execute();
        new HistogramDisplay(letters,"Caracter").execute();

    }
}
