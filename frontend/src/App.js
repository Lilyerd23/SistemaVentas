import './App.css';
import Menu                                       from "./menuOpciones/menu";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import ComponenteCliente                          from "./ClienteComponent/ComponenteCliente";
import ListarClientes                             from "./ClienteComponent/ListarClientes";
import ListarTipos                                from "./ClienteComponent/ListarTipos";
import ListarDetalles                             from "./ClienteComponent/ListarDetalles";
import ListarProductos                            from "./ProductoComponent/ListarProductos";
import RegistrarProductos                         from "./ProductoComponent/RegistrarProductos";

function App() {
    return (
        <div>
            <Router>
                <Menu/>
                <div className="components">
                    <Switch>
                        <Route path="/component-clientes" exact component={ ComponenteCliente }/>
                        <Route path="/view-clientes" exact component={ ListarClientes }/>
                        <Route path="/view-tipos" exact component={ ListarTipos }/>
                        <Route path="/view-detalles" exact component={ ListarDetalles }/>

                        <Route path="/product-list" exact component={ ListarProductos }/>
                        <Route path="/registro-cliente/:id" exact component={ RegistrarProductos }/>
                    </Switch>
                </div>
            </Router>
        </div>
    );
}

export default App;
