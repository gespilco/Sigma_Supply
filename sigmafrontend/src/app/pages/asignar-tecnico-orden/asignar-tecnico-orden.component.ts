import { Component, OnInit } from '@angular/core';
import { BsModalRef, BsModalService } from 'ngx-bootstrap/modal';
import { Busqueda } from 'src/app/_model/busqueda';
import { OrdenServicioService } from 'src/app/_service/orden-servicio.service';
import { TipoPrioridadService } from 'src/app/_service/tipo-prioridad.service';
import { TipoSolicitudService } from 'src/app/_service/tipo_solicitud.service';
import { EstadoSolicitudService } from 'src/app/_service/estado-solicitud.service';
import { EstadoService } from 'src/app/_service/estado.service';
import { ActualizaService } from 'src/app/_service/actualiza.service';
import { OrdenServicio } from 'src/app/_model/orden-servicio';
import { ModalAsignarTecnicoComponent } from './modal-asignar-tecnico/modal-asignar-tecnico.component';

@Component({
  selector: 'app-asignar-tecnico-orden',
  templateUrl: './asignar-tecnico-orden.component.html',
  styleUrls: ['./asignar-tecnico-orden.component.scss']
})
export class AsignarTecnicoOrdenComponent implements OnInit {

  listaSolicitudes: any = [];
  listaEstadoSolicitud: any = [];
  listaTipoSolicitud: any = [];
  listaTipoPrioridad: any = [];
  listaOrdenServicio: any = [];
  listaParametroSistema: any = [];
  listaOrdenServicioPar: any = [];
  ordenEnvio: any;

  numOrdenMask = ['O', 'R', 'D', '-', /[0-9]/, /\d/, /\d/, /\d/, /\d/, /\d/];
  idTipoDescripcion;
  idEstadoSolicitud;

  selectedTipoSolicitud;
  selectEstadoSolicitud;
  totalRegistros = 0;
  totalfilasPorPagina = 0;
  paginaActiva = 0;
  numeroPagina = 5;
  numFilas = 5;
  numPaginasMostrar = 5;
  paginaActual: number = 0;

  config;
  bsModal: BsModalRef;
  busqueda: Busqueda;

  constructor(
    private servicioOrden: OrdenServicioService,
    private modalService: BsModalService,
    private servicioTipoPrioridad: TipoPrioridadService,
    private servicioTipoSolicitud: TipoSolicitudService,
    private servicioEstadoSolicitud: EstadoSolicitudService,
    private servicioEstado: EstadoService,
    private actualizaService: ActualizaService
  ) { }

  ngOnInit() {
    this.busqueda = new Busqueda();
    this.listarOrdensServicio();
    this.listarTipoSolicitud();
    this.listarEstadoSolicitud();
    this.ConsultaPrincipal(this.busqueda);


  }

  ConsultaPrincipal(busqueda: Busqueda) {

    this.listarOrdenServicioPar(busqueda);
  }

  listarTipoPrioridad() {
    this.servicioTipoPrioridad.listarTipoPrioridad().subscribe(
      data => {
        this.listaTipoPrioridad = data;
      }
    );
  }
  listarTipoSolicitud() {
    this.servicioTipoSolicitud.listarTipoSolicitud().subscribe(
      data => {
        this.listaTipoSolicitud = data;
      }
    );
  }

  listarEstadoSolicitud() {
    this.servicioEstado.listarEstado().subscribe(
      data => {
        this.listaEstadoSolicitud = data;
      }
    );
  }

  listarOrdensServicio() {

    this.servicioOrden.listarOrdenServicio().subscribe(
      data => {
        this.listaSolicitudes = data;
        this.totalfilasPorPagina = this.listaSolicitudes.length;
      });

  }


  listarOrdenServicioPar(busqueda: Busqueda) {
    let _id_orden = parseInt(busqueda.numero_orden.replace('_', '').replace('_', '').replace('_', '').replace('_', '').replace('_', '').replace('_', '').replace('ORD-', ''));
    if (!_id_orden)
      _id_orden = 0;

      this.servicioOrden.listarOrdenServicioPag(_id_orden, this.formatDate(busqueda.fecha_recepcion), busqueda.id_tipo_solicitud, busqueda.id_estado, this.paginaActiva, this.numeroPagina).subscribe(
      data => {

        if (JSON.parse(data[0]).lista_orden_servicio !== null) {
          this.listaOrdenServicioPar = JSON.parse(data[0]).lista_orden_servicio;
          this.totalfilasPorPagina = this.listaOrdenServicioPar.length;
          this.totalRegistros = this.listaOrdenServicioPar[0].total_registros;
        } else {
          this.listaOrdenServicioPar = [];
          this.totalfilasPorPagina = 0;
          this.totalRegistros = 0;
        }

      });
  }

  exportarReporte() {

  }

  LimpiarControles() {
    this.busqueda = new Busqueda();
    this.ConsultaPrincipal(this.busqueda);

  }

  cambiarPagina(pagina) {
    this.paginaActual = pagina.page;
    this.paginaActiva = ((this.paginaActual - 1) * this.numPaginasMostrar);
    this.numeroPagina = this.numPaginasMostrar;
    this.ConsultaPrincipal(this.busqueda);
  }

  openModal(ordenServicio: OrdenServicio) {

    this.actualizaService.seteo(this.paginaActual, this.busqueda);

    this.config = {
      ignoreBackdropClick: true,
      keyboard: false,
      animated: true,
      class: 'modal-extra',
      initialState: {
        ordenServicioPase: ordenServicio,
      }
    };

    this.bsModal = this.modalService.show(ModalAsignarTecnicoComponent, this.config);
    this.bsModal.content.retorno.subscribe(
      data => {
        
        this.paginaActual = this.actualizaService.numeroPagina;
        this.paginaActiva = ((this.paginaActual - 1) * this.numPaginasMostrar);
        this.ConsultaPrincipal(this.actualizaService.busqueda);
      }
    );
  }

  diferenciaFechas(fechaInicio, fechaFin) {
    const f1: Date = new Date(fechaInicio);
    const f2: Date = new Date(fechaFin);

    const resultado = ((f2.getTime() - f1.getTime()) / 1000 / 60 / 60);

    return resultado.toFixed(2);
  }

  formatDate(date) {
    var d = new Date(date),
      month = '' + (d.getMonth() + 1),
      day = '' + d.getDate(),
      year = d.getFullYear();

    if (month.length < 2)
      month = '0' + month;
    if (day.length < 2)
      day = '0' + day;


    if (!year)
      return '19000101';
    else
      return [year, month, day].join('');
  }
  Number(valor): number {


    return parseFloat(valor);
  }



}
