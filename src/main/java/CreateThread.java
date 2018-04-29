public class CreateThread {

    public int counter = 0;

    public void runThread() throws InterruptedException {
        final Thread thread1 = new Thread(new Runnable() {
            public void run() {
                try {
                    for (int i = 0; i < 1000; i++) {
                        addCounter();
                        //Sleep methodu ile thraed işmini her yaptıktan sora 10milisaniye bekliyor.
                        Thread.sleep(10);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        final Thread thread2 = new Thread(new Runnable() {
            public void run() {

                try {
                    for (int i = 0; i < 1000; i++) {
                        addCounter();
                        //Sleep methodu ile thraed işmini her yaptıktan sora 10milisaniye bekliyor.
                        Thread.sleep(10);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Counter: " + counter);
    }

    //Thread 1 bu methodu cagırıp işini bitirmeden thread2 bu methodu kullanamaz.
    //Thread 2 bu methodu cagırıp işini bitirmeden thread1 bu methodu kullanamaz.
    //Bunu synchronized keyword ile yapıyoruz.
    //Bu keyword'u kullanamazsak counter 2.000 değerine hiç ulaşamayacak.
    private synchronized void addCounter() {
        counter++;
    }

}
