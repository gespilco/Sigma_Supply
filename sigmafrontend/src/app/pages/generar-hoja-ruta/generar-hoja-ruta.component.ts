import { Component, OnInit } from '@angular/core';
import { Programacion } from 'src/app/_model/programacion';
import { BsModalRef, BsModalService } from 'ngx-bootstrap/modal';
import { ProgramacionService } from 'src/app/_service/programacion.service';
import { ModalGenerarHojaRutaComponent } from './modal-generar-hoja-ruta/modal-generar-hoja-ruta.component';
import { Tecnico } from 'src/app/_model/tecnico';
import { TecnicoService } from 'src/app/_service/tecnico.service';
import { ProgramaVisitaService } from 'src/app/_service/programa-visita.service';
import { ProgramaVisita } from 'src/app/_model/programavisita';
import { HojaRutasService } from 'src/app/_service/hoja-ruta.service';
import { Busqueda } from 'src/app/_model/busqueda';

@Component({
  selector: 'app-generar-hoja-ruta',
  templateUrl: './generar-hoja-ruta.component.html',
  styleUrls: ['./generar-hoja-ruta.component.scss']
})
export class GenerarHojaRutaComponent implements OnInit {

  listaHojaRuta: any = [];
  listaVisitasProgramadas: any = [];
  listaProgramaVisita: any = [];
  totalfilasPorPagina = 0;
  paginaActiva = 0;
  numeroPagina = 5;
  numFilas = 10;
  numPaginasMostrar = 5;
  totalRegistros = 0;
  fechaInicio: Date;
  fechaFin: Date;
  selectTecnico: any;
  listaTecnico: any;
  busqueda:Busqueda;
  paginaActual: number = 0;

  config;
  bsModal: BsModalRef;

  constructor(
    private modalService: BsModalService,
    private programacionService: ProgramacionService,
    private tecnicoService: TecnicoService,
    private programaVisitaService: ProgramaVisitaService,
    private hojaRutasService: HojaRutasService
  ) { }

  ngOnInit() {
    this.busqueda = new Busqueda();
    this.listaTecnicos();
    this.ConsultaPrincipal(this.busqueda);
  }

  verHojaRuta(programavisita: ProgramaVisita) {

    this.programacionService.listarProgramacion().subscribe(
      data => {
        console.log(data);

        this.listaVisitasProgramadas = data;
      }

    )

  }

  generarHojaRuta(programavisita: ProgramaVisita) {
    this.hojaRutasService.generarHojaRuta(programavisita.id_programa_visita).subscribe(
      data => {
        console.log(data);
      }
    );

  }

  listarHojaRuta(programavisita: ProgramaVisita) {

    this.programacionService.listarProgramacion().subscribe(
      data => {
        console.log(data);

        this.listaVisitasProgramadas = data;
      }

    )

  }
  listaTecnicos() {
    this.tecnicoService.listarTecnicos().subscribe(
      data => {
        this.listaTecnico = data;
      }
    )

  }

  openModalMapa1(programacion: Programacion) {

    this.config = {
      ignoreBackdropClick: true,
      keyboard: false,
      animated: true,
      class: 'modal-extra',
      initialState: {
        listaHojaRuta: programacion
      }
    };

    this.bsModal = this.modalService.show(ModalGenerarHojaRutaComponent, this.config);
  }


  openModalMapa(id: number) {

    this.config = {
      ignoreBackdropClick: true,
      keyboard: false,
      animated: true,
      class: 'modal-extra',
      initialState: {
        listaHojaRuta: id
      }
    };

    this.bsModal = this.modalService.show(ModalGenerarHojaRutaComponent, this.config);
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

  ConsultaPrincipal(busqueda: Busqueda) {
    this.programaVisitaService.listarProgramaVisita(busqueda.id_tecnico,this.formatDate(busqueda.fecha),this.paginaActiva, this.numeroPagina).subscribe(
      data=>{
        if (JSON.parse(data[0]).lista_programa_visita !== null) {
          this.listaProgramaVisita = JSON.parse(data[0]).lista_programa_visita;       
          this.totalfilasPorPagina = this.listaProgramaVisita.length;
          this.totalRegistros = this.listaProgramaVisita[0].total_registros;
        } else {
          this.listaProgramaVisita = [];
          this.totalfilasPorPagina = 0;
          this.totalRegistros = 0;
        }
      }
    );
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

}
