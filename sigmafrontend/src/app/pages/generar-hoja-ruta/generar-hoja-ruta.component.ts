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
  numeroPagina = 0;
  numFilas = 10;
  numPaginasMostrar = 5;
  totalRegistros = 0;
  fechaInicio: Date;
  fechaFin: Date;
  selectTecnico: any;
  listaTecnico: any;

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

    this.listaTecnicos();
    //this.listarHojaRuta();
    this.listaPrincipal();
  }
  listaPrincipal() {
    this.programaVisitaService.listarVisitas().subscribe(
      data => {
        console.log(data);
        this.listaProgramaVisita = data;
      }
    );
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
        console.log(data);
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

  }

  BuscarHojaRuta() {
    console.log(this.selectTecnico);

  }
  cambiarPagina(pagina) {
    this.paginaActiva = ((pagina.page - 1) * this.numPaginasMostrar);
    this.numeroPagina = this.paginaActiva;
    /*this.listarHojaRuta();*/
  }


}
