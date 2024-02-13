/**
 * The Main creates patient and manager objects,
 * and implements simulateOnlyByPriority, simulateOnlyByCreation methhods.
 */


public class Main {


    /**
     * a function that creates few patient objects and adds them to a manager object.
     *
     * @param m - the manager object all patient will be added to.
     *
     */
    public static void f1 (Manager m)
    {
        Patient p1 = new Patient(9, false);
        Patient p2 = new Patient(7, true);
        Patient p3 = new Patient(4, false);
        Patient p4 = new Patient(1, true);
        Patient p5 = new Patient(3, false);
        Patient p6 = new Patient(8, false);
        Patient p7 = new Patient(12, false);
        Patient p8 = new Patient(2, true);
        Patient p9 = new Patient(4, false);
        Patient p10 = new Patient(5, true);
        Patient p11= new Patient(13, false);
        Patient p12 = new Patient(6, false);
        m.add(p1);
        m.add(p2);
        m.add(p3);
        m.add(p4);
        m.add(p5);
        m.add(p6);
        m.add(p7);
        m.add(p8);
        m.add(p9);
        m.add(p10);
        m.add(p11);
        m.add(p12);
    }

    /**
     * a function that prints all patients by priority from a manager object.
     * @param m - the manager object to be printed by priority.
     */
    public static void simulateOnlyByPriority (Manager m)
    {
        Patient p = (Patient)m.getByPriority();
        while (p != null)
        {
            System.out.println(p);
            p=(Patient)m.getByPriority();
        }
    }

    /**
     * a function that prints all patients by creation time from a manager object.
     * @param m - the manager object to be printed by creation time.
     */
    public static void simulateOnlyByCreation (Manager m)
    {
        Patient p = (Patient)m.getByCreationTime();
        while (p != null)
        {
            System.out.println(p);
            p=(Patient)m.getByCreationTime();
        }
    }




    public static void main(String[] args) {

        Manager<Patient> yoav = new Manager<Patient>();
        f1(yoav);
        simulateOnlyByPriority (yoav);
        simulateOnlyByCreation (yoav);




    }
}