//Ahmad Fahad Alzhrani 201917030
class Patient implements Comparable<Patient> {
   String name;
   int emergencyLevel;

   public Patient(String name, int emergencyLevel) {
      this.name = name;
      this.emergencyLevel = emergencyLevel;
   }

   public int compareTo(Patient o) {
      if (this.emergencyLevel == o.emergencyLevel)
         if (this.name.compareTo(o.name) > 0) {
            return 1;
         } else
            return -1;
      else if (this.emergencyLevel > o.emergencyLevel)
         return 1;
      else
         return -1;
   }

   @Override
   public String toString() {
      return "Patient Name>> " + name + ", " + "Emergency Level>> " + emergencyLevel;
   }
}