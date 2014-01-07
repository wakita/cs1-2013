package kwakita.cs1.app.techdraw2;

abstract class MVC {
    protected Model model;
    protected View view;
    protected Control control;
    
    MVC() {}
    
    abstract class Model {
        protected Model() {
            model = this;
        }
    }
    
    abstract class View {
        protected View() {
            view = this;
        }
    }
    
    abstract class Control {
        protected Control() {
            control = this;
        }
    }
}
