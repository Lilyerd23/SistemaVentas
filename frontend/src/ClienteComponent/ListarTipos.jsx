import "./styles/ListarTipo.scss"
import React, { Component } from "react";
import TipoService          from "./service/TipoService";
import { FontAwesomeIcon }  from "@fortawesome/react-fontawesome";
import { faPen }            from "@fortawesome/free-solid-svg-icons"
import { faTrash }          from "@fortawesome/free-solid-svg-icons"

class ListarTipos extends Component {

    constructor( props ) {
        super( props );
        this.state = {
            tipos : [],
            idTIPO : '',
            nombre : '',
            isEditar : false
        };

        this.handleActions = this.handleActions.bind( this );
        this.eliminarTipo = this.eliminarTipo.bind( this );

        this.changeTipoHandler = this.changeTipoHandler.bind( this );
        this.chooseMethod = this.chooseMethod.bind( this );
    }

    componentDidMount() {
        TipoService.mostrarTipos()
                   .then( lista => {
                       this.setState( { tipos : lista.data } )
                   } )
    }

    /*============ Selecciona el metodo: nuevo o actualizar ===========*/
    chooseMethod( e ) {
        e.preventDefault()
        let Tipo = {
            id : null,
            tipo : this.state.nombre
        }
        if ( this.state.isEditar ) {
            Tipo.id = this.state.idTIPO;
            TipoService.actualizarTipo( Tipo )
                       .then( () => {
                           window.location.reload()
                       } )
        } else {
            TipoService.crearTipo( Tipo )
                       .then( () => {
                           window.location.reload();
                       } )
        }
    }

    /*=================================================================*/

    changeTipoHandler = ( event ) => {
        this.setState( { nombre : event.target.value } );
    }

    /*================= Editar los datos ==============*/
    handleActions( id_TIPO ) {
        this.setState( {
            isEditar : true
        } );
        this.state.idTIPO = id_TIPO;
        TipoService.buscarTipoporID( id_TIPO )
                   .then( ( resultado ) => {
                       let tipoSelect = resultado.data;
                       this.setState( {
                           nombre : tipoSelect.tipo
                       } )
                   } );
    }

    /*=================================================*/


    eliminarTipo( id ) {
        TipoService.eliminarTipo( id )
                   .then( () => {
                       this.setState( {
                           tipos : this.state.tipos.filter(
                               tipo => tipo.id !== id )
                       } )
                   } )
    }

    /*======= Cambiar el titulo del formulario ==========*/
    getTitulo() {
        if ( this.state.isEditar ) {
            return <h2>Modificar</h2>
        } else {
            return <h2>Nuevo</h2>
        }
    }

    /*==================================================*/

    render() {
        return (
            <div>
                <div className="container_ctipos">
                    <div className="franja-titulo">
                        <h2>Tipos de Clientes</h2>
                    </div>
                    <br/>

                    <div className="contenedor">
                        <div className="formulario">
                            { this.getTitulo() }
                            <form>
                                <div className="field">
                                    <span/>
                                    <input type="text"
                                           required
                                           name="nombre"
                                           placeholder="Nombre"
                                           value={ this.state.nombre }
                                           onChange={ this.changeTipoHandler }/>
                                </div>
                                <div className="field space">
                                    <a className="btn_tguardar" onClick={ this.chooseMethod }>
                                        <span/>
                                        <span/>
                                        <span/>
                                        <span/>
                                        Guardar
                                    </a>
                                </div>
                            </form>
                        </div>
                    </div>

                    <div className="contenedor">
                        <table className="tabla-tipos">
                            <thead>
                            <tr className="contenido-titulo-tabla">
                                <th>Nombre</th>
                                <th>Acciones</th>
                            </tr>
                            </thead>
                            <tbody>{
                                this.state.tipos.map(
                                    tipo =>
                                        <tr key={ tipo.id }>
                                            <td>{ tipo.tipo }</td>
                                            <td>
                                                <div className="wrapper">
                                                    <a className="btnEditar"
                                                       onClick={ () => this.handleActions( tipo.id ) }>
                                                        <i><FontAwesomeIcon icon={ faPen } className="iconFont"/></i>
                                                    </a>
                                                </div>
                                                <div className="wrapper">
                                                    <a href={ "/view-tipos" } className="btnEliminar"
                                                       onClick={ () => this.eliminarTipo( tipo.id ) }>
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

export default ListarTipos