package business.model;

public class VacationDirector {
        protected VacationBuilder vacBuilder;
     
        public VacationDirector(VacationBuilder vacBuilder) {
            this.vacBuilder = vacBuilder;
        }
     
        public void buildKindVacation() {
            vacBuilder.buildKindVacation();
        }
     
        public Vacation getVacation() {
            return vacBuilder.getVacation();
        }
}
    