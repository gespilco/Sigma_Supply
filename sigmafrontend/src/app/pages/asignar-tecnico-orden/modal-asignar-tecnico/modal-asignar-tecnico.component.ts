import { Component, OnInit, Output, EventEmitter } from '@angular/core';

import { Tecnico } from 'src/app/_model/tecnico';
import { OrdenServicioTecnicoService } from 'src/app/_service/orden-servicio-tecnico.service';
import { BsModalRef } from 'ngx-bootstrap/modal';
import { TecnicoService } from 'src/app/_service/tecnico.service';
import { ParametroSistemaService } from 'src/app/_service/parametro-sistema.service';
import { OrdenServicioService } from 'src/app/_service/orden-servicio.service';
import { Funciones } from 'src/app/_shared/funciones';
import { OrdenServicioTecnico } from 'src/app/_model/orden-servicio-tecnico';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-modal-asignar-tecnico',
  templateUrl: './modal-asignar-tecnico.component.html',
  styleUrls: ['./modal-asignar-tecnico.component.scss']
})
export class ModalAsignarTecnicoComponent implements OnInit {

  listaTecnicoAlgoritmo: any = [];
  listaTecnicoAlgoritmoB: any = [];
  listaTecnicoAgregados: any = [];
  listaParametroSistema: any = [];

  @Output()
  retorno = new EventEmitter();


  objTecnico: Tecnico;

  selectTecnico: any;

  ordenServicioPase: any;
  ordenServicioPasev2: any;
  bEstado = false;
  constructor(
    private ordenTecnicoService: OrdenServicioTecnicoService,
    private modalRef: BsModalRef,
    private tecnicoServicio: TecnicoService,
    private parametroSistemaService: ParametroSistemaService,
    private ordenServicioTecnicoService: OrdenServicioTecnicoService,
    private ordenServicioService: OrdenServicioService,
    public funciones: Funciones
  ) { }

  ngOnInit() {
    this.listarTecnicos();
    this.parametrosSistema();
  }

  eliminarTecnico(pos) {
    var objEliminar = this.listaTecnicoAgregados.find(function (value, index) {
      if (index == pos) {
        return value;
      }
    });

    this.ordenServicioTecnicoService.obtenerOrdenServiciosTecnico(this.ordenServicioPase.id_orden_servicio, objEliminar.id_tecnico).subscribe(data => {
      let dat = JSON.parse(data[0]);

      if (dat != null) {

        Swal.fire({
          title: 'Desea Eliminar Técnico',
          text: "No se podrá revertir esto!",
          type: 'warning',
          showCancelButton: true,
          confirmButtonText: 'Si',
          cancelButtonText: 'No',
          reverseButtons: true
        }).then((result) => {
          if (result.value) {

            this.eliminardeverdad(dat,pos);

          } else if (
            /* Read more about handling dismissals below */
            result.dismiss === Swal.DismissReason.cancel
          ) {
            Swal.fire(
              'Cancelado',
              'Tu registro esta seguro',
              'error'
            )
          }
        });


      } else {
        this.listaTecnicoAgregados.splice(pos, 1);

        this.tecnicoServicio.listarTecnicoAlgoritmo(this.ordenServicioPase.solicitud.id_solicitud).subscribe(
          dataTS => {
            this.listaTecnicoAlgoritmo = JSON.parse(dataTS[0]);
            this.actulizaTecnicoSugerido();
          });

      }


    });
  }

  eliminardeverdad(dat,pos) {

    this.ordenServicioTecnicoService.eliminarOrdenServiciosTecnico(dat[0].id_orden_servicio_tecnico).subscribe(value => {
      if (!value) {
        this.listaTecnicoAgregados.splice(pos, 1);
        this.tecnicoServicio.listarTecnicoAlgoritmo(this.ordenServicioPase.solicitud[0].id_solicitud).subscribe(
          dataTS => {
            this.listaTecnicoAlgoritmo = JSON.parse(dataTS[0]);
            this.actulizaTecnicoSugerido();
          });
      }
    });





  }
  listarTecnicos() {
    let lista: any[] = [];

    this.tecnicoServicio.listarTecnicoAlgoritmo(this.ordenServicioPase.solicitud.id_solicitud).subscribe(
      data => {

        this.ordenServicioTecnicoService.listarOrdenServiciosTecnico(this.ordenServicioPase.id_orden_servicio).subscribe(
          data2 => {

            this.listaTecnicoAlgoritmo = JSON.parse(data[0]); //COMBO
            if (JSON.parse(data2[0]) != null) {
              this.listaTecnicoAgregados = JSON.parse(data2[0]);

              this.actulizaTecnicoSugerido();

            } else {

              this.listaTecnicoAgregados = [];
            }

          }
        );
      }
    );
  }
  listarTecnicosAlgoritmo() {
    this.tecnicoServicio.listarTecnicoAlgoritmo(this.ordenServicioPase.solicitud.id_solicitud).subscribe(
      data => {
        this.listaTecnicoAlgoritmo = JSON.parse(data[0]);
      }
    );
  }

  listarTecnicosOrden() {

    this.ordenServicioTecnicoService.listarOrdenServiciosTecnico(this.ordenServicioPase.id_orden_servicio).subscribe(
      data => {

        let objOrdTec: any[] = [];


        if (JSON.parse(data[0]) == null) {
          this.listaTecnicoAgregados = [];
        } else {
          objOrdTec = JSON.parse(data[0]);
          objOrdTec.forEach(obj => {
            this.buscarTecnico(obj.id_tecnico);
          });


        }
      }
    );
  }
  actulizaTecnicoSugerido() {
    var array_ = this.listaTecnicoAlgoritmo;


    var array2 = this.listaTecnicoAgregados;

    var eee = array_.filter(function (elemento) {
      if ((array2.filter(x => x.id_tecnico === elemento.id_tecnico).length) == 0) return elemento;
    });

    this.listaTecnicoAlgoritmo = eee;
    this.LimpiarControles();
  }
  buscarTecnico(id) {
    if (id != null || 0) {
      this.bEstado = true;
      if (this.listaTecnicoAgregados.length == 0) {
        this.tecnicoServicio.listarTecnicoId(id).subscribe(data => {
          const temp = data;
          this.listaTecnicoAgregados.push(temp);
          this.actulizaTecnicoSugerido();

        });
      } else {
        let encontrado = false;
        this.listaTecnicoAgregados.forEach(element => {
          if (id === element.id_tecnico) {
            encontrado = true;
          }
        });
        if (!encontrado) {
          this.tecnicoServicio.listarTecnicoId(id).subscribe(data => {
            const temp: any = data;
            this.listaTecnicoAgregados.push(temp);

            this.actulizaTecnicoSugerido();
          });
        }
      }
    }
    // this.listarTecnicos();
  }

  AsignarTecnicos() {

    Swal.fire({
      title: 'Desea Asignar Técnico(s)',
      type: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Si',
      cancelButtonText: 'No',
      reverseButtons: true
    }).then((result) => {
      if (result.value) {
        this.asignardeverdad();
      } else if (
        /* Read more about handling dismissals below */
        result.dismiss === Swal.DismissReason.cancel
      ) {
        Swal.fire(
          'Cancelado',
          'No se agregaron tecnico(s)',
          'error'
        )
      }
    })

  }

  asignardeverdad() {
    let contar = 0;

    if (this.listaTecnicoAgregados.length > 0) {

      this.ordenServicioService.listarOrdenServicioId(this.ordenServicioPase.id_orden_servicio).subscribe(
        data => {

          this.ordenServicioPasev2 = data;

          this.listaTecnicoAgregados.forEach(element => {
            const ordenServicioTecnico: OrdenServicioTecnico = new OrdenServicioTecnico();
            this.ordenServicioTecnicoService.obtenerOrdenServiciosTecnico(this.ordenServicioPasev2.id_orden_servicio, element.id_tecnico).subscribe(data => {

              if (JSON.parse(data[0]) != null) {

                ordenServicioTecnico.id_orden_servicio_tecnico = JSON.parse(data[0])[0].id_orden_servicio_tecnico;
              } else {
                ordenServicioTecnico.id_orden_servicio_tecnico = 0;
              }
              ordenServicioTecnico.tecnico = element;
              ordenServicioTecnico.ordenServicio = this.ordenServicioPasev2;
              ordenServicioTecnico.comentario = 'Tecnico asignado';
              ordenServicioTecnico.activo = true;

              if (ordenServicioTecnico.id_orden_servicio_tecnico == 0) {

                this.ordenTecnicoService.registrarOrdenServicioTecnico(ordenServicioTecnico).subscribe(
                  data => {

                    this.funciones.mensaje('success', this.funciones.mostrarMensaje('insertar', ''));

                    this.retorno.emit('0');
                    this.modalRef.hide();

                  }
                );
              } else {
                this.ordenTecnicoService.actualizarOrdenServicioTecnico(ordenServicioTecnico).subscribe(
                  data => {
                    this.funciones.mensaje('success', this.funciones.mostrarMensaje('actualizar', ''));

                    this.retorno.emit('0');

                    this.modalRef.hide();

                  }
                );
              }

            });

          });

        }
      );

    }


  }

  closeModal() {
    this.retorno.emit('0');
    this.modalRef.hide();
  }

  agregarTecnico() {

  }

  LimpiarControles() {
    this.selectTecnico = null;
  }

  parametrosSistema() {
    this.parametroSistemaService.listarParametroSistemaSol(this.ordenServicioPase.solicitud.id_solicitud).subscribe(
      data => {
        this.listaParametroSistema = JSON.parse(data[0]);

      });

  }

}
