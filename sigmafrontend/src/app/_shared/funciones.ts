//import swal from 'sweetalert2/dist/sweetalert2.js'
import Swal from 'sweetalert2'
import 'sweetalert2/src/sweetalert2.scss'
//import createNumberMask from 'text-mask-addons/dist/createNumberMask';
// import * as CryptoJS from "crypto-js";

export type String = "";

export class Funciones {

    // key = CryptoJS.enc.Utf8.parse("7061737323313233");
    // iv = CryptoJS.enc.Utf8.parse("7061737323313233");
    
    alertaEliminar(tipo: any, titulo: string, texto: string, cancel: boolean, condicion: any){
        Swal.fire({
            title: 'Are you sure?',
            text: "You won't be able to revert this!",
            type: 'warning',
            showCancelButton: true,
            confirmButtonText: 'Si',
            cancelButtonText: 'No',
            reverseButtons: true
          }).then((result) => {
            if (result.value) {
                Swal.fire(
                'Eliminado',
                'El registro fue eliminado',
                'success'
              )
            } else if (
              /* Read more about handling dismissals below */
              result.dismiss === Swal.DismissReason.cancel
            ) {
                Swal.fire(
                'Cancelado',
                'N',
                'error'
              )
            }
          })  
      }



    alertaRetorno(tipo: any, titulo: string, texto: string, cancel: boolean, condicion: any) {
        
        Swal.fire({
            title: titulo,
            type: tipo,
            html: texto,
            showCancelButton: cancel,
            allowOutsideClick: false
        }).then(condicion);
    }

    alertaSimple(tipo: any, titulo: string, texto: string, confirmar: boolean) {
        Swal.fire({
            title: titulo,
            type: tipo,
            text: texto,
            allowOutsideClick: false,
            showConfirmButton: confirmar
        });
    }
    cerrarAlerta() {
        Swal.close();
    }

    mostrarMensaje(tipo, nombreCampo) {
        var mensaje = "";
        if (tipo == "insertar") {
            mensaje = "Se realizó satisfactoriamente el registro.";
        } else if (tipo == "actualizar") {
            mensaje = "Se realizó satisfactoriamente la actualización.";
        } else if (tipo == "eliminacion") {
            mensaje = "Se realizó satisfactoriamente la eliminación del registro.";
        } else if (tipo == "error") {
            mensaje = "Hubo un error en el sistema. Consulte con el administrador.";
        } else if (tipo == "validación") {
            mensaje = "El dato" + nombreCampo + " es obligatorio.";
        }

        return mensaje;
    }

    IsNumberKey(event) {
        if (event.charCode >= 48 && event.charCode <= 57) {
            return true;
        }
        return false;
    }
    ObtenerFechaDescarga() {
        var d = new Date(),
            month = '' + (d.getUTCMonth() + 1),
            day = '' + d.getUTCDate(),
            year = '' + d.getFullYear(),
            hora = '' + d.getHours(),
            minutos = '' + d.getMinutes(),
            segundos = '' + d.getSeconds();
        if (month.length < 2) month = '0' + month;
        if (day.length < 2) day = '0' + day;

        return [day, month, year].join('/') + " " + [hora, minutos, segundos].join(':');
    }

    obtenerFechaDescargaGuardarArchivo() {
        var d = new Date(),
            month = '' + (d.getUTCMonth() + 1),
            day = '' + d.getUTCDate(),
            year = '' + d.getFullYear(),
            hora = '' + d.getHours(),
            minutos = '' + d.getMinutes(),
            segundos = '' + d.getSeconds();
        if (month.length < 2) month = '0' + month;
        if (day.length < 2) day = '0' + day;

        return [day, month, year].join('_') + "_" + [hora, minutos, segundos].join('');
    }

    formatDate(date) {
        var d = new Date(date),
            month = '' + (d.getUTCMonth() + 1),
            day = '' + d.getUTCDate(),
            year = d.getFullYear();
        if (month.length < 2) month = '0' + month;
        if (day.length < 2) day = '0' + day;

        return [day, month, year].join('/');
    }
    formatDateAAAAMMDD(date) {
        var d = new Date(date),
            month = '' + (d.getUTCMonth() + 1),
            day = '' + d.getUTCDate(),
            year = d.getFullYear();
        if (month.length < 2) month = '0' + month;
        if (day.length < 2) day = '0' + day;

        return [year, month, day].join('-');
    }

    formatDateMDY(date) {
        var d = new Date(date),
            month = '' + (d.getUTCMonth() + 1),
            day = '' + d.getUTCDate(),
            year = d.getFullYear();
        if (month.length < 2) month = '0' + month;
        if (day.length < 2) day = '0' + day;

        return [month, day, year].join('/');
    }

    ConvertStringtoDate(fecha) {
        var parts = fecha.split('/');
        var mydate = new Date(parts[2], parts[1] - 1, parts[0]);
        return mydate;
    }

    ConvertStringtoDateDB(fecha) {
        var parts = fecha.split('-');
        var mydate = new Date(parts[0], parts[1] - 1, parts[2]);
        return mydate;
    }

    SumDaytoDate(fecha: Date, dias: number) {
        var fechaAumentada = new Date(fecha);
        var retorno = new Date(fechaAumentada.setDate(fechaAumentada.getDate() + dias));
        return retorno;
    }

    mensaje(tipo: string, mensaje: string) {
        this.alertaSimple(tipo, "", mensaje, true);
    }

    setearValorDecimal(input) {
        var num;
        if (input.length > 2) {
            if (!input.toString().includes(".")) {
                num = input.toString() + "00";
            } else {
                var arrMonto = input.toString().split('.');
                if (arrMonto[1].length == 1) {
                    input = input.toString() + '0';
                }
                num = input.toString().replace('.', '');
                num = num.toString().replace(/\,/g, '');
            }
        } else {
            num = input;
        }
        return num;
    }
    format(input) {
        var num = input.replace(/\./g, '');
        num = num.replace(/\,/g, '');

        if (!isNaN(num)) {
            if (num.length > 2) {
                num = num.substring(0, num.length - 2) + '.' + num.substring(num.length - 2);
            }
            input = num;
        }
        else {
            input = input.replace(/[^\d\.]*/g, '');
        }
        input = this.addCommas(input)
        var resultado = input;
        return resultado;
    }

    addCommas(nStr) {
        nStr += '';
        let x = nStr.split('.');
        let x1 = x[0];
        let x2 = x.length > 1 ? '.' + x[1] : '';
        var rgx = /(\d+)(\d{3})/;
        while (rgx.test(x1)) {
            x1 = x1.replace(rgx, '$1' + ',' + '$2');
        }
        return x1 + x2;
    }

    fixed(numero: number, decimales: number) {
        numero = Number(numero.toFixed(decimales));
        return numero;
    }

    IsFloat(event) {
        var key = window.event ? event.which : event.keyCode;
        var chark = String.fromCharCode(key);
        var tempValue = event.currentTarget.value + chark;
        if (key >= 48 && key <= 57) {
            if (this.filter(tempValue) === false) {
                return false;
            } else {
                return true;
            }
        } else {
            if (key == 8 || key == 13 || key == 0) {
                return true;
            } else if (key == 46) {
                if (this.filter(tempValue) === false) {
                    return false;
                } else {
                    return true;
                }
            } else {
                return false;
            }
        }
    }

    filter(__val__) {
        var preg = /^([0-9]+\.?[0-9]{0,2})$/;
        if (preg.test(__val__) === true) {
            return true;
        } else {
            return false;
        }
    }

    IsMenor(valor, numero: number) {
        valor === undefined ? valor = 0 : valor;
        if (valor <= numero) {
            return valor;
        } else {
            let cadena = valor.toString();
            return parseInt(cadena.slice(0, -1));
        }
    }

    castToFloat(monto: number | string): number {
        if (monto == 0 || monto == "") {
            return 0;
        }
        let valueWithReplace = monto.toString().replace(/,/g, "");
        let value = Number.parseFloat(valueWithReplace);
        return value;
    }

    numberWithCommas = (x) => {
        return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    }

    numberRange(valor: number, numInferior: number, numSuperior: number) {
        valor == undefined || valor == null ? valor = numInferior : valor;
        if (valor < numInferior || valor > numSuperior) {
            let valorCadena = valor.toString();
            let valorEntero: number = parseInt(valorCadena.slice(0, -1));
            return valorEntero = isNaN(valorEntero) ? numInferior : valorEntero;
        } else {
            return valor;
        }
    }

    /* public currencyMask = createNumberMask({
        prefix: '',
        suffix: '',
        includeThousandsSeparator: true,
        thousandsSeparatorSymbol: ',',
        allowDecimal: true,
        decimalSymbol: '.',
        decimalLimit: 2,
        integerLimit: null,
        requireDecimal: false,
        allowNegative: false,
        allowLeadingZeroes: false
    });

    public percentageMask = createNumberMask({
        prefix: '',
        suffix: '',
        includeThousandsSeparator: false,
        thousandsSeparatorSymbol: ',',
        allowDecimal: true,
        decimalSymbol: '.',
        decimalLimit: 2,
        integerLimit: null,
        requireDecimal: false,
        allowNegative: false,
        allowLeadingZeroes: false,
        maxValue: 100,
        minValue: 0
    }); */

    obtenerPeriodo(periodo: string): string {
        if (periodo == null || periodo == "" || periodo.length < 6) return "";

        let mes = periodo.substring(0, 2);
        let anio = periodo.substring(2, 6);
        let resultado = (mes == "01" ? "Enero" :
            mes == "02" ? "Febrero" :
                mes == "03" ? "Marzo" :
                    mes == "04" ? "Abril" :
                        mes == "05" ? "Mayo" :
                            mes == "06" ? "Junio" :
                                mes == "07" ? "Julio" :
                                    mes == "08" ? "Agosto" :
                                        mes == "09" ? "Setiembre" :
                                            mes == "10" ? "Octubre" :
                                                mes == "11" ? "Noviembre" : "Diciembre") + " " + anio;
        return resultado;
    }

    obtenerAbreviacionMes(mes: number): string {
        let resultado = (mes == 1 ? "Enero" :
            mes == 2 ? "Febrero" :
                mes == 3 ? "Marzo" :
                    mes == 4 ? "Abril" :
                        mes == 5 ? "Mayo" :
                            mes == 6 ? "Junio" :
                                mes == 7 ? "Julio" :
                                    mes == 8 ? "Agosto" :
                                        mes == 9 ? "Setiembre" :
                                            mes == 10 ? "Octubre" :
                                                mes == 11 ? "Noviembre" : "Diciembre");
        return resultado;
    }

    obtenerCorrelativoMes(mes: number): string {
        let resultado = "";
        if (mes > 9) {
            resultado = mes.toString();
        } else {
            resultado = "0" + mes.toString();
        }

        return resultado;
    }


    contarNumeroMeses(arrMatrizMeses, anio) {
        let cont = 0;
        arrMatrizMeses.forEach(element => {
            if (element.Anio == anio) {
                cont++;
            }
        });

        return cont;
    }

    obtenerMatrizDiferenciaFechas(pfechaInicio, pfechaFin) {
        let arrAnioMeses = [];
        let mesInicio = parseInt(pfechaInicio.split('/')[1]);
        let mesFin = parseInt(pfechaFin.split('/')[1]);
        let mesInicioTemporal = 1;
        let mesFinTemporal = 12;

        let anioInicio = parseInt(pfechaInicio.split('/')[2]);
        let anioFin = parseInt(pfechaFin.split('/')[2]);

        for (let i = anioInicio; i <= anioFin; i++) {
            if (i > anioInicio && i < anioFin) {
                mesInicioTemporal = 1;
                mesFinTemporal = 12;
            } else if (i == anioInicio && i == anioFin) {
                mesInicioTemporal = mesInicio;
                mesFinTemporal = mesFin;
            } else if (i == anioInicio && i < anioFin) {
                mesInicioTemporal = mesInicio;
                mesFinTemporal = 12;
            } else if (i > anioInicio && i == anioFin) {
                mesInicioTemporal = 1;
                mesFinTemporal = mesFin;
            }

            for (let j = mesInicioTemporal; j <= mesFinTemporal; j++) {
                arrAnioMeses.push({ "Anio": i, "Mes": j });
            }
        }
        return arrAnioMeses;
    }
    obtenerDiferenciaMeses(pfechaInicio, pfechaFin) {
        let mesInicio: number;
        let mesFin: number;
        let anioInicio: number;
        let anioFin: number;
        let diferenciaMeses: number;

        mesInicio = parseInt(pfechaInicio.split('/')[1]);
        mesFin = parseInt(pfechaFin.split('/')[1]);
        anioInicio = parseInt(pfechaInicio.split('/')[2]);
        anioFin = parseInt(pfechaFin.split('/')[2]);
        diferenciaMeses = (anioFin * 12 + mesFin) - (anioInicio * 12 + mesInicio)

        return diferenciaMeses + 1;
    }


    formatFullDate(date) {
        var d = new Date(date),
            month = '' + (d.getUTCMonth() + 1),
            day = '' + d.getUTCDate(),
            year = '' + d.getFullYear(),
            hora = '' + d.getHours(),
            minutos = '' + d.getMinutes(),
            segundos = '' + d.getSeconds();
        if (month.length < 2) month = '0' + month;
        if (day.length < 2) day = '0' + day;

        if (parseInt(segundos) < 10) {
            segundos = "0" + segundos;
        }
        if (parseInt(minutos) < 10) {
            minutos = "0" + minutos;
        }

        return [day, month, year].join('/') + " " + [hora, minutos, segundos].join(':');
    }
    autosize(this) {
        var el = this;
        setTimeout(function () {
            el.style.cssText = 'height:auto; padding:0';
            // for box-sizing other than "content-box" use:
            // el.style.cssText = '-moz-box-sizing:content-box';
            el.style.cssText = 'height:' + el.scrollHeight + 'px';
        }, 0);
    }

    validarCaracteresRaros(e) {
        let tecla = (document.all) ? e.keyCode : e.which;

        //Tecla de retroceso para borrar, siempre la permite
        if (tecla == 8) {
            return true;
        }

        // Patron de entrada, en este caso solo acepta numeros y letras
        let patron = /[A-Za-z0-9-'_]/;
        let tecla_final = String.fromCharCode(tecla);
        return patron.test(tecla_final);
    }

    formatSize(size: number) {
        let kbytes = 1024;
        let operacion: number = 0;
        let respuesta: any;
        if (size >= kbytes) {
            if (size > kbytes * kbytes) {
                if (size > kbytes * kbytes * kbytes) {
                    operacion = size / (kbytes * kbytes * kbytes);
                    respuesta = this.fixed(operacion, 2) + ' GB';
                }
                else {
                    operacion = size / (kbytes * kbytes);
                    respuesta = this.fixed(operacion, 2) + ' MB';
                }
            }
            else {
                operacion = size / kbytes;
                respuesta = this.fixed(operacion, 2) + ' KB';
            }
        }
        else {
            operacion = size;
            respuesta = operacion + ' bytes';
        }
        return respuesta;
    }

    // encriptar(trama: string): string {
    //     // let encrypted = CryptoJS.AES.encrypt(CryptoJS.enc.Utf8.parse(trama), this.key,
    //     // {
    //     // keySize: 128 / 8,
    //     // iv: this.iv,
    //     // mode: CryptoJS.mode.CBC,
    //     // padding: CryptoJS.pad.Pkcs7
    //     // });
    //     let encrypted = CryptoJS.AES.encrypt(trama, "69").toString();
    //     return encrypted;
    // }
    // desencriptar(encryptTex): string {

    //     let decrypted = CryptoJS.AES.decrypt(encryptTex, "69").toString(CryptoJS.enc.Utf8);
    //     return decrypted;
    // }
    fechaString(fecha: String): string {
        let dd = fecha.substring(0, 2);
        let mm = fecha.substring(3, 5);
        let yyyy = fecha.substring(6, 8);
        return '20' + yyyy + '-' + mm + '-' + dd;
    }
    convertirFechaString(fecha: String): string {
        var parts = fecha.split('/');
        let dd = parts[0];
        let mm = parts[1];
        let yyyy = parts[2];
        return yyyy + '-' + mm + '-' + dd;
    }
}