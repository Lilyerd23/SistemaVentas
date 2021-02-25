import "./styles/RegistrarProducto.scss"
import React, { Component } from "react";
import ProductoService      from "./service/ProductoService";
import MarcaService         from "./service/MarcaService";
import CategoriaService     from "./service/CategoriaService";

class RegistrarProductos extends Component {

    constructor( props ) {
        super( props );

        this.state = {
            categorias : [],
            marcas : [],

            id : this.props.match.params.id,
            nombre : '',
            precioC : '',
            precioV : '',
            cantidad : '',
            estado : '',
            categoriaId : '',
            marcaId : ''
        }
    }

    componentDidMount() {
        CategoriaService.mostrarCategorias()
                        .then( listaCat => {
                            this.setState( { categorias : listaCat.data } )
                        } )
        MarcaService.mostrarMarcas()
                    .then( listaM => {
                        this.setState( { marcas : listaM.data } )
                    } )
        if ( !(this.state.id === "agregar") ) {
            ProductoService.buscarProductoPorID( this.state.id )
                           .then( ( result ) => {
                               console.log(result.data)
                           } )
        }
    }

    chooseMethod = ( e ) => {
        e.preventDefault()
    }

    getTitulo() {
        if ( !(this.state.id === "agregar") ) {
            return <h2 className="title_registerP">Modificar Producto</h2>
        } else {
            return <h2 className="title_registerP">Registrar Producto</h2>
        }
    }

    render() {
        return (
            <div>
                {/*=========================================================*/ }
                <br/>
                <div className="registerProduct_Title">
                    { this.getTitulo() }
                </div>
                {/*=========================================================*/ }
                <div className="container_registerP">
                    <div className="form_registerP">

                    </div>
                    <div className="container-listCM">
                        <div className="container-marca">

                        </div>
                        <div className="container-categoria">

                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default RegistrarProductos