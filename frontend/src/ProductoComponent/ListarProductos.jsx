import "./styles/ListarProducto.scss"
import React, { Component }          from "react";
import ProductoService               from "./service/ProductoService";
import { FontAwesomeIcon }           from "@fortawesome/react-fontawesome";
import { faBoxOpen, faPen, faTrash } from "@fortawesome/free-solid-svg-icons";

class ListarProductos extends Component {

    constructor( props ) {
        super( props );
        this.state = {
            productos : []
        }

        this.agregarProducto = this.agregarProducto.bind( this );
        this.editarProducto = this.editarProducto.bind( this );
    }

    componentDidMount() {
        ProductoService.mostrarProductos()
                       .then( listaP => {
                           this.setState( { productos : listaP.data } )
                       } )
    }

    agregarProducto() {
        this.props.history.push( "/registro-cliente/agregar" )
    }

    editarProducto( IDproducto ) {
        this.props.history.push( "/registro-cliente/" + IDproducto )
    }

    render() {
        return (
            <div>
                {/*=========================================================*/ }
                <br/>
                <div className="listProduct_Title">
                    <h2 className="title_listP">Lista de Productos</h2>
                </div>
                {/*=========================================================*/ }

                {/*================== Lista de productos ===================*/ }
                <div className="container_listaP">
                    <div className="box-nuevo">
                        <div className="box-add">
                            <a className="btn-add btnNew" onClick={ this.agregarProducto }>
                                <i className="icon-addBtn"><FontAwesomeIcon icon={ faBoxOpen }/></i>
                                Nuevo Producto
                            </a>
                        </div>
                    </div>

                    <div className="box-tabla">
                        <table className="table-productos">
                            <thead>
                            <tr className="tabla-cabecera">
                                <th className="Ttabla">Categoria</th>
                                <th className="Ttabla">Marca</th>
                                <th className="Ttabla">Nombre</th>
                                <th className="Ttabla">Precio de Compra</th>
                                <th className="Ttabla">Precio de Venta</th>
                                <th className="Ttabla">Cantidad</th>
                                <th className="Ttabla">Estado</th>
                                <th className="Ttabla">Acciones</th>
                            </tr>
                            </thead>
                            <tbody>{
                                this.state.productos.map(
                                    producto =>
                                        <tr key={ producto.id }>
                                            <td>{ producto.categoria.nombre }</td>
                                            <td>{ producto.marca.nombre }</td>
                                            <td>{ producto.nombre }</td>
                                            <td>{ producto.precioCompra }</td>
                                            <td>{ producto.precioVenta }</td>
                                            <td>{ producto.cantidad }</td>
                                            <td>{ producto.estado }</td>
                                            <td>
                                                <div className="wrapper">
                                                    <a className="btnEditar"
                                                       onClick={ () => this.editarProducto( producto.id ) }>
                                                        <i><FontAwesomeIcon icon={ faPen } className="iconFont"/></i>
                                                    </a>
                                                </div>
                                                <div className="wrapper">
                                                    <a href={ "/product-list" } className="btnEliminar">
                                                        <i><FontAwesomeIcon icon={ faTrash } className="iconFont"/></i>
                                                    </a>
                                                </div>
                                            </td>
                                        </tr>
                                )
                            }</tbody>
                        </table>
                    </div>
                </div>
            </div>
        )
    }
}

export default ListarProductos