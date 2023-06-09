package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("BOB","BOBOVICH","BOB@MAIL.RU");
      User user2 = new User("DIMAR","DIMAROVICH","DIMAR@MAIL.RU");
      User user3 = new User("ARTUR","ARTUROVICH","ARTUR@MAIL.RU");
      User user4 = new User("BAGUR","BAGUROVICH", "BAGUR@MAIL.RU");

      user1.setCar(new Car("Audi",4));
      user2.setCar(new Car("Lada",2110));
      user3.setCar(new Car("Mazda",3));
      user4.setCar(new Car("Yaz",63));

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);
//      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = "+user.getCar());
         System.out.println(userService.userByCar("Audi",4).toString());
         System.out.println();
      }

      context.close();
   }
}
