package facade;

public class ComputerFacade {

    public void run(CPU cpu,HardDrive hardDrive,Memory memory){
        cpu.processData();
        hardDrive.readData();
        memory.load();
    }
}
