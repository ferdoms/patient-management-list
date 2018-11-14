package patientmanagementsys;

public interface PatientNodeInterface {
	public void addFirst(Patient item);	
	public void addAfter(PatientNode<Patient> node, Patient item); 
	public Patient removeFirst();
	public Patient removeAfter(PatientNode<Patient> node); 
	public Patient get(int index);
	public Patient set(int index, Patient newValue);
	public Patient remove(int index);
	public void add(int index, Patient Patient);
	public boolean add(Patient item);
	public boolean remove(Patient item);
	public PatientNode<Patient> getNode(int index);
	public int size();
}
