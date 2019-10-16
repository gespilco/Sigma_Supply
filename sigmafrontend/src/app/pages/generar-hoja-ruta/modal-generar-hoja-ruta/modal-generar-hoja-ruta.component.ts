import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { BsModalRef } from 'ngx-bootstrap/modal';
import 'leaflet';
import 'leaflet-routing-machine';
import { timeout } from 'q';
import { TecnicoService } from 'src/app/_service/tecnico.service';


declare let L;

@Component({
  selector: 'app-modal-generar-hoja-ruta',
  templateUrl: './modal-generar-hoja-ruta.component.html',
  styleUrls: ['./modal-generar-hoja-ruta.component.scss']
})
export class ModalGenerarHojaRutaComponent implements OnInit {

  map: any;
  DataShape: any;
  Lgeojson: any;
  MapaJson: any;
  DepartamentoActual = '00';
  NombreDepartamento = '';

  listaHojaRuta: any;
  listaTecnicos:any;

  constructor(
    private http: HttpClient, 
    private router: Router, 
    private modalRef: BsModalRef,
    private tecnicoService: TecnicoService) { }

  ngOnInit() {
    setTimeout(() => {
      this.generarmapa();
    }, 500);

  }

  generarmapa() {
    this.map = L.map('map').setView([-12.0700991, -77.0422714], 12);

    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
      attribution: '© <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
    }).addTo(this.map);
    
    
    if (this.listaHojaRuta === 1) {
      L.Routing.control({
        waypoints: [
          L.latLng(-11.81318, -77.13572),
          L.latLng(-11.81357, -77.13683),
          L.latLng(-11.81366, -77.13696),
          L.latLng(-11.81525, -77.1316766),
          L.latLng(-11.81538, -77.13883),
          L.latLng(-11.8157, -77.13267),
          L.latLng(-11.81607, -77.13334),
          L.latLng(-11.83887, -77.11358)
        ]
      }).addTo(this.map);



    } else if (this.listaHojaRuta === 2) {
      L.Routing.control({
        waypoints: [
          L.latLng(-12.042, -77.03809),
          L.latLng(-12.042555, -77.04056),
          L.latLng(-12.042594, -77.042561),
          L.latLng(-12.04261, -77.036024),
          L.latLng(-12.04294, -77.03264),
          L.latLng(-12.04298, -77.03413),
          L.latLng(-12.042985, -77.038455),
          L.latLng(-12.043287, -77.033652),
          L.latLng(-12.043898, -77.031127)
        ]
      }).addTo(this.map);
    } else if (this.listaHojaRuta === 3) {

      L.Routing.control({
        waypoints: [
          L.latLng(-12.04442,-77.01277),
          L.latLng(-12.044857,-77.011791),
          L.latLng(-12.04521,-77.01368),
          L.latLng(-12.04557,-77.01447),
          L.latLng(-12.046009,-77.015596),
          L.latLng(-12.046399,-77.01568),
          L.latLng(-12.04665,-77.01369),
          L.latLng(-12.04666,-77.0164),
          L.latLng(-12.04701,-77.01551),
          L.latLng(-12.04741,-77.01845)
        ]
      }).addTo(this.map);
    } else if (this.listaHojaRuta === 4) {
      L.Routing.control({
        waypoints: [
          L.latLng(-12.469935,-76.75091),
          L.latLng(-12.48125,-76.79655),
          L.latLng(-12.48241,-76.80041),
          L.latLng(-12.48253,-76.79684),
          L.latLng(-12.48352,-76.79671),
          L.latLng(-12.48516,-76.7967),
          L.latLng(-12.48564,-76.79633),
          L.latLng(-12.48821,-76.79447),
          L.latLng(-12.48884,-76.79437),
          L.latLng(-12.48915,-76.79421)          
        ]
      }).addTo(this.map);

    } else {

      L.Routing.control({
        waypoints: [
          L.latLng(-11.73361, -77.14381),
          L.latLng(-11.73379, -77.145983),
          L.latLng(-11.73413, -77.14338),
          L.latLng(-11.73654, -77.14251),
          L.latLng(-11.74237, -77.15046),
          L.latLng(-11.75633, -77.15448)
        ]
      }).addTo(this.map);
    }


  }

  CargarShapeDB() {
    const path = './assets/mapa/00.json';
    this.http.get(path).subscribe((data: any) => {
      this.MapaJson = data;
      this.DataShape = JSON.parse(JSON.stringify(this.MapaJson));
      this.AddGeojson();

    });
  }

  Procesar(CodDepartamentoActual?: any) {
    if (CodDepartamentoActual !== undefined) {
      this.DepartamentoActual = CodDepartamentoActual;
    }

    // tslint:disable-next-line: triple-equals
    if (this.DepartamentoActual === '00') {
      this.DataShape = JSON.parse(JSON.stringify(this.MapaJson));
      this.AddGeojson();
    }
    if (this.DepartamentoActual !== '00') {
      let shapeJson;
      shapeJson = this.MapaJson.features.filter(x => x.properties.iddpto === this.DepartamentoActual);
      this.NombreDepartamento = this.MapaJson.features.filter(x => x.properties.iddpto === this.DepartamentoActual)[0].properties.nombdep;
      this.DataShape = JSON.parse(JSON.stringify(shapeJson));
      this.AddGeojson();
    }
  }

  AddGeojson() {
    const principal = this;
    this.RemoveGeojson();
    this.Lgeojson = L.geoJSON(principal.DataShape, {
      onEachFeature(feature, layer) {

        layer.myTag = 'myGeoJSON';
        // tslint:disable-next-line: only-arrow-functions
        layer.on('click', function (e) {
          if (principal.DepartamentoActual === '00') {
            const info = e.target.feature.properties;
            principal.NombreDepartamento = info.nombdep;
            principal.DepartamentoActual = info.iddpto;
            principal.Procesar();

          }


        });
        // tslint:disable-next-line: only-arrow-functions
        layer.on('mouseover', function (e) {
          // layer.bindPopup("dasdas", { sticky: true });
          // layer.bindTooltip(e.target.feature.properties.nombdep, { sticky: true });
          // layer.bindTooltip(principal.DetalleHover(e.target.feature.properties.iddpto)).openTooltip();
        });
      }
    });
    this.Lgeojson.addTo(this.map);
    this.map.fitBounds(this.Lgeojson.getBounds());

  }

  CargarShape(event?: any, CodDepartamentoActual?: string) {

    let shapeJson;
    if (this.DepartamentoActual !== '00') {
      shapeJson = this.MapaJson.features.filter(x => x.properties.iddpto === this.DepartamentoActual);
    } else {
      event.preventDefault();
      shapeJson = JSON.parse(JSON.stringify(this.MapaJson));
      this.DepartamentoActual = '00';
      this.NombreDepartamento = '';
    }
    this.DataShape = JSON.parse(JSON.stringify(shapeJson));
    this.AddGeojson();
  }

  RemoveGeojson() {
    const map = this.map;
    // tslint:disable-next-line: only-arrow-functions
    map.eachLayer(function (layer) {
      if (layer.hasOwnProperty('myTag')) {
        if (layer.myTag && layer.myTag === 'myGeoJSON') {
          map.removeLayer(layer);
        }
      }
    });
  }

  closeModal() {
    this.modalRef.hide();
  }


}
