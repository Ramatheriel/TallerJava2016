/*
 * Universidad de las Americas, A.C.
 * Licenciatura en Informatica y Tecnologias de la Informacion.
 * Ricardo Meneses Pardo
 * 77148
 */
package Parcial1;

/**
 *
 * @author Ricardo
 */
public class TestClass 
{
    public static void main(String[] args)
    {
        Director d;
        d = Director.getDirector();
        
        ConcreteAggregate listaApps = new ConcreteAggregate();
        
        d.setBuilder(new BuilderJuegos());
        d.buildAplicacion();
        Aplicacion appJuegos = d.getAplicacion();
        listaApps.add(appJuegos);
        
        d.setBuilder(new BuilderFitness());
        d.buildAplicacion();
        Aplicacion appFitness = d.getAplicacion();
        listaApps.add(appFitness);
        
        d.setBuilder(new BuilderIdiomas());
        d.buildAplicacion();
        Aplicacion appIdiomas = d.getAplicacion();
        listaApps.add(appIdiomas);
        
        d.setBuilder(new BuilderMusica());
        d.buildAplicacion();
        Aplicacion appMusica = d.getAplicacion();
        listaApps.add(appMusica);
        
        for (Iterator i = listaApps.createIterator() ; i.isDone(); )
        {
            Aplicacion app;
            app = (Aplicacion) i.next();
            app.imprimeApp();
        }
    }
    
}
