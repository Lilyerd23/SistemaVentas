import "./styles/RegistrarProducto.scss"
import React, { Component } from "react";
import ProductoService      from "./service/ProductoService";
import MarcaService         from "./service/MarcaService";
import CategoriaService     from "./service/CategoriaService";
import { FontAwesomeIcon }  from "@fortawesome/react-fontawesome";
import { faPen, faTrash }   from "@fortawesome/free-solid-svg-icons";

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
            marcaId : '',

            categoriaNombre : '',
            marcaNombre : ''
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
                               console.log( result.data )
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
                        <div className="container-form1">
                            <div className="form-part1">
                                <form className="form">
                                    <input type="text" name="nombre" value={ this.state.nombre }
                                           required/>
                                    <label className="lbl">
                                            <span className="txt">
                                                Nombre
                                            </span>
                                    </label>
                                </form>
                                <form className="form">
                                    <input type="number" name="cantidad" value={ this.state.cantidad }
                                           required/>
                                    <label className="lbl">
                                            <span className="txt">
                                                Cantidad
                                            </span>
                                    </label>
                                </form>
                            </div>
                            <div className="form-part2">
                                <form className="form">
                                    <input type="text" name="nombre" value={ this.state.categoriaNombre }
                                           style={ { cursor : "default" } }/>
                                    <label className="lbl">
                                            <span className="txt">
                                                Categoria
                                            </span>
                                    </label>
                                </form>
                                <form className="form">
                                    <input type="text" name="nombre" value={ this.state.marcaNombre }
                                           style={ { cursor : "default" } }/>
                                    <label className="lbl">
                                            <span className="txt">
                                                Marca
                                            </span>
                                    </label>
                                </form>
                            </div>
                        </div>
                        <div>
                            <fieldset>
                                <legend className="legend-title">Precio</legend>
                                <div className="form-precio">
                                    <form className="form">
                                        <input type="number" name="cantidad" value={ this.state.cantidad }
                                               required/>
                                        <label className="lbl">
                                            <span className="txt">
                                                Venta
                                            </span>
                                        </label>
                                    </form>
                                    <form className="form compra">
                                        <input type="number" name="cantidad" value={ this.state.cantidad }
                                               required/>
                                        <label className="lbl">
                                            <span className="txt">
                                                Compra
                                            </span>
                                        </label>
                                    </form>
                                </div>
                            </fieldset>
                            <div className="container-estado">
                                <form className="form">
                                    <input type="text" name="nombre" value={ this.state.nombre }
                                           required/>
                                    <label className="lbl">
                                            <span className="txt">
                                                Estado
                                            </span>
                                    </label>
                                </form>
                            </div>
                        </div>
                        <div className="container-btns">
                            <a className="btn-guardar">
                                Guardar
                            </a>
                            <a href={ "/product-list" } className="btn-cancelar">
                                Cancelar
                            </a>
                        </div>
                    </div>
                    <div className="container-listCM">
                        <div className="container-categoria">
                            <fieldset className="categoria-box">
                                <legend className="legend-title_C">Categoria</legend>
                                <div className="formulario-categoria">
                                    <form>
                                        <div className="field-categoria">
                                            <span/>
                                            <input type="text"
                                                   name="nombre"
                                                   placeholder="Nombre"
                                                   value={ this.state.categoriaNombre }/>
                                        </div>
                                        <div className="field-catego space-categ">
                                            <a className="btn_guardar-categ" onClick={ this.chooseMethod }>
                                                Guardar
                                            </a>
                                        </div>
                                    </form>
                                </div>
                                <div>
                                    <div className="tabla-categorias">
                                        <thead>
                                        <tr>
                                            <th style={ { background : '#2361ab' } }/>
                                            <th className="title-P">Nombre</th>
                                            <th className="title-P">Acciones</th>
                                        </tr>
                                        </thead>
                                        <tbody>{
                                            this.state.categorias.map(
                                                categoria =>
                                                    <tr key={ categoria.id }>
                                                        <td/>
                                                        <td>{ categoria.nombre }</td>
                                                        <td>
                                                            <div className="wrapper">
                                                                <a className="btnEditar">
                                                                    <i><FontAwesomeIcon icon={ faPen }
                                                                                        className="iconFont"/></i>
                                                                </a>
                                                            </div>
                                                            <div className="wrapper">
                                                                <a className="btnEliminar">
                                                                    <i><FontAwesomeIcon icon={ faTrash }
                                                                                        className="iconFont"/></i>
                                                                </a>
                                                            </div>
                                                        </td>
                                                    </tr>
                                            )
                                        }</tbody>
                                    </div>
                                </div>
                            </fieldset>
                        </div>
                        <div className="container-marca">
                            <fieldset className="marca-box">
                                <legend className="legend-title_M">Marca</legend>
                                <div className="formulario-marca">
                                    <form>
                                        <div className="field-marca">
                                            <span/>
                                            <input type="text"
                                                   name="nombre"
                                                   placeholder="Nombre"
                                                   value={ this.state.marcaNombre }/>
                                        </div>
                                        <div className="field-marc space-marca">
                                            <a className="btn_guardar-marca" onClick={ this.chooseMethod }>
                                                Guardar
                                            </a>
                                        </div>
                                    </form>
                                </div>
                                <div>
                                    <div className="tabla-marcas">
                                        <thead>
                                        <tr>
                                            <th style={ { background : '#2361ab' } }/>
                                            <th className="title-P">Nombre</th>
                                            <th className="title-P">Acciones</th>
                                        </tr>
                                        </thead>
                                        <tbody>{
                                            this.state.marcas.map(
                                                marca =>
                                                    <tr key={ marca.id }>
                                                        <td/>
                                                        <td>{ marca.nombre }</td>
                                                        <td>
                                                            <div className="wrapper">
                                                                <a className="btnEditar">
                                                                    <i><FontAwesomeIcon icon={ faPen }
                                                                                        className="iconFont"/></i>
                                                                </a>
                                                            </div>
                                                            <div className="wrapper">
                                                                <a className="btnEliminar">
                                                                    <i><FontAwesomeIcon icon={ faTrash }
                                                                                        className="iconFont"/></i>
                                                                </a>
                                                            </div>
                                                        </td>
                                                    </tr>
                                            )
                                        }</tbody>
                                    </div>
                                </div>
                            </fieldset>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default RegistrarProductos