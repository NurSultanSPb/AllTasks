package Logging;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Log1 {

    public static final String AUSTIN_POWERS = "Austin Powers";
    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";


    public static void main(String[] args) throws UnsupportedEncodingException {

        Logger logger = Logger.getLogger(Log1.class.getName());
        logger.setLevel(Level.INFO);
        Inspector inspector = new Inspector();
        Spy spy = new Spy(logger);
        Thief thief = new Thief(10000);
        MailService variousWorkers[] = new MailService[]{spy, thief, inspector};
        UntrustworthyMailWorker worker = new UntrustworthyMailWorker(variousWorkers);
        Package pack1 = new Package("ВВЖ", 32);
        Package pack2 = new Package("рпакетный двигатель ", 2500000);
        Package pack3 = new Package("stones", 1000);
        Package pack4 = new Package("banned substance", 99);
        Package pack5 = new Package("tiny bomb", 9000);
        AbstractSendable correspondence[] = {
                new MailMessage("Oxxxymiron", "Гнойный", "Я здесь чисто по фану, поглумиться над слабым\n" +
                        "Ты же вылез из мамы под мой дисс на Бабана...."),
                new MailMessage("Гнойный", "Oxxxymiron", "....Что? Так болел за Россию, что на нервах терял ганглии.\n" +
                        "Но когда тут проходили митинги, где ты сидел? В Англии!...."),
                new MailMessage("Жриновский", AUSTIN_POWERS, "Бери пацанов, и несите меня к воде."),
                new MailMessage(AUSTIN_POWERS, "Пацаны", "Го, потаскаем Вольфовича как Клеопатру"),
                new MailPackage("берег", "море", pack1),
                new MailMessage("NASA", AUSTIN_POWERS, "Найди в России ракетные двигатели и лунные stones"),
                new MailPackage(AUSTIN_POWERS, "NASA", pack2),
                new MailPackage(AUSTIN_POWERS, "NASA", pack3),
                new MailPackage("Китай", "КНДР", pack4),
                new MailPackage(AUSTIN_POWERS, "ИГИЛ (запрещенная группировка", pack5),
                new MailMessage(AUSTIN_POWERS, "Психиатр", "Помогите"),
        };
        Arrays.stream(correspondence).forEach(parcell -> {
            try {
                worker.processMail(parcell);
            } catch (StolenPackageException e) {
                logger.log(Level.WARNING, "Inspector found stolen package: " + e);
            } catch (IllegalPackageException e) {
                logger.log(Level.WARNING, "Inspector found illegal package: " + e);
            }
        });

        System.out.println(thief.getStolenValue());
    }

    /*
    Интерфейс: сущность, которую можно отправить по почте.
    У такой сущности можно получить от кого и кому направляется письмо.
    */

    public static interface Sendable {
        String getFrom();
        String getTo();
    }


    /*
    Абстрактный класс,который позволяет абстрагировать логику хранения
    источника и получателя письма в соответствующих полях класса.
    */

    public static abstract class AbstractSendable implements Sendable {

        protected final String from;
        protected final String to;

        public AbstractSendable(String from, String to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public String getFrom() {
            return from;
        }

        @Override
        public String getTo() {
            return to;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            AbstractSendable that = (AbstractSendable) o;

            if (!from.equals(that.from)) return false;
            if (!to.equals(that.to)) return false;

            return true;
        }

    }


    /*
    Письмо, у которого есть текст, который можно получить с помощью метода `getMessage`
    */
    public static class MailMessage extends AbstractSendable {

        private final String message;

        public MailMessage(String from, String to, String message) {
            super(from, to);
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;

            MailMessage that = (MailMessage) o;

            if (message != null ? !message.equals(that.message) : that.message != null) return false;

            return true;
        }

    }


    /*
    Посылка, содержимое которой можно получить с помощью метода `getContent`
    */
    public static class MailPackage extends AbstractSendable {
        private final Package content;

        public MailPackage(String from, String to, Package content) {
            super(from, to);
            this.content = content;
        }

        public Package getContent() {
            return content;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;

            MailPackage that = (MailPackage) o;

            if (!content.equals(that.content)) return false;

            return true;
        }

    }


    /*
    Класс, который задает посылку. У посылки есть текстовое описание содержимого и целочисленная ценность.
    */
    public static class Package {
        private final String content;
        private final int price;

        public Package(String content, int price) {
            this.content = content;
            this.price = price;
        }

        public String getContent() {
            return content;
        }

        public int getPrice() {
            return price;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Package aPackage = (Package) o;

            if (price != aPackage.price) return false;
            if (!content.equals(aPackage.content)) return false;

            return true;
        }
    }


    /*
    Интерфейс, который задает класс, который может каким-либо образом обработать почтовый объект.
    */
    public static interface MailService {
        Sendable processMail(Sendable mail);
    }

    /*
    Класс, в котором скрыта логика настоящей почты
    */
    public static class RealMailService implements MailService {

        @Override
        public Sendable processMail(Sendable mail) {
            // Здесь описан код настоящей системы отправки почты.
            return mail;
        }
    }


    public static class UntrustworthyMailWorker implements MailService {
        MailService[] mailServices;
        RealMailService realMailService = new RealMailService();

        public UntrustworthyMailWorker (MailService[] mailServices) {
            this.mailServices = mailServices;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            Sendable mailResult = mail;
            for (MailService service: mailServices) {
                mailResult = service.processMail(mailResult);
            }
            return getRealMailService().processMail(mailResult);
        }

        public RealMailService getRealMailService() {
            return realMailService;
        } //here in real
    }



    public static class Spy implements MailService {
        private static Logger LOGGER;
        public Spy (Logger LOGGER) {
            this.LOGGER = LOGGER;
        }

        @Override
        public Sendable processMail(Sendable mail) {

            if (mail instanceof MailMessage) {
                MailMessage mailMessage = (MailMessage) mail;
                if (mailMessage.from.equals(AUSTIN_POWERS) || mailMessage.to.equals(AUSTIN_POWERS)) {
                    LOGGER.log(Level.WARNING, "Detected target mail correspondence: from "
                            + mailMessage.from + " to " + mailMessage.to + " \"" + mailMessage.getMessage() + "\"");
                } else {
                    LOGGER.log(Level.INFO, "Usual correspondence: from " + mailMessage.from + " to " + mailMessage.to);
                } // here in If
            }

            return mail;
        } //here in LOGGER
    }


    public static class Thief implements MailService{
        public int value;
        public int stolenValue;
        public Thief (int value) {
            this.value = value;
        }
        public int getStolenValue() {
            return stolenValue;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailPackage) {
                MailPackage mailPackage = (MailPackage) mail;
                Package pack = mailPackage.getContent();
                if (pack.getPrice() >= value) {
                    stolenValue = stolenValue + pack.getPrice();
                    return new MailPackage(mailPackage.from, mailPackage.to, new Package("stones instead of " + pack.getContent(),0));
                } else {
                    return mail;
                }

            } else {
                return mail;
            }
        } //here in Thief
    }



    public static class Inspector implements MailService {

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailPackage) {
                MailPackage mailPackage = (MailPackage) mail;
                Package pack = mailPackage.getContent();
                if (pack.getContent().contains(WEAPONS) || pack.getContent().contains(BANNED_SUBSTANCE)) {
                    throw new IllegalPackageException();
                } else if (pack.getContent().contains("stones")) {
                    throw new StolenPackageException();
                }
                return mail;
            } else {
                return mail;
            }
        }
    }

    public static class IllegalPackageException extends RuntimeException {
    }

    public static class StolenPackageException extends RuntimeException {
    }
}
