package com.damajo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.damajo.dao.ContentsDAO;
import com.damajo.dao.DetailDAO;
import com.damajo.vo.CpuVO;
import com.damajo.vo.HddVO;
import com.damajo.vo.MainVO;
import com.damajo.vo.PowerVO;
import com.damajo.vo.RamVO;
import com.damajo.vo.SsdVO;
import com.damajo.vo.VgaVO;

@Service
public class ContentsService {
	@Autowired
	private ContentsDAO dao;
	@Autowired
	private DetailDAO detaildao;

	public List<CpuVO> cpuContentsList(Map map) {
		List<CpuVO> cpuList=dao.cpuContentsList(map);
		for(CpuVO vo:cpuList) {
			String cpu_name=vo.getCpu_name();
			if(cpu_name.length()>43) {
				cpu_name=cpu_name.substring(0,42)+"...";
				vo.setCpu_name(cpu_name);
			}
		}
		return cpuList;
	}
	public int cpuTotalPage() {
		return dao.cpuTotalPage();
	}

	public List<RamVO> ramContentsList(Map map) {
		List<RamVO> ramList=dao.ramContentsList(map);
		for(RamVO vo:ramList) {
			String ram_name=vo.getRam_name();
			if(ram_name.length()>43) {
				ram_name=ram_name.substring(0,42)+"...";
				vo.setRam_name(ram_name);
			}
		}
		return ramList;
	}
	public int ramTotalPage() {
		return dao.ramTotalPage();
	}

	public List<MainVO> mainContentsList(Map map) {
		List<MainVO> mainList=dao.mainContentsList(map);
		for(MainVO vo:mainList) {
			String main_name=vo.getMain_name();
			if(main_name.length()>43) {
				main_name=main_name.substring(0,42)+"...";
				vo.setMain_name(main_name);
			}
		}
		return mainList;
	}
	public int mainTotalPage() {
		return dao.mainTotalPage();
	}

	public List<VgaVO> vgaContentsList(Map map) {
		List<VgaVO> vgaList=dao.vgaContentsList(map);
		for(VgaVO vo:vgaList) {
			String vga_name=vo.getVga_name();
			if(vga_name.length()>43) {
				vga_name=vga_name.substring(0,42)+"...";
				vo.setVga_name(vga_name);
			}
		}
		return vgaList;
	}
	public int vgaTotalPage() {
		return dao.vgaTotalPage();
	}

	public List<SsdVO> ssdContentsList(Map map) {
		List<SsdVO> ssdList=dao.ssdContentsList(map);
		for(SsdVO vo:ssdList) {
			String ssd_name=vo.getSsd_name();
			if(ssd_name.length()>43) {
				ssd_name=ssd_name.substring(0,42)+"...";
				vo.setSsd_name(ssd_name);
			}
		}
		return ssdList;
	}
	public int ssdTotalPage() {
		return dao.ssdTotalPage();
	}

	public List<HddVO> hddContentsList(Map map) {
		List<HddVO> hddList=dao.hddContentsList(map);
		for(HddVO vo:hddList) {
			String hdd_name=vo.getHdd_name();
			if(hdd_name.length()>43) {
				hdd_name=hdd_name.substring(0,42)+"...";
				vo.setHdd_name(hdd_name);
			}
		}
		return hddList;
	}
	public int hddTotalPage() {
		return dao.hddTotalPage();
	}

	public List<PowerVO> powerContentsList(Map map) {
		List<PowerVO> powerList=dao.powerContentsList(map);
		for(PowerVO vo:powerList) {
			String power_name=vo.getPower_name();
			if(power_name.length()>43) {
				power_name=power_name.substring(0,42)+"...";
				vo.setPower_name(power_name);
			}
		}
		return powerList;
	}
	public int powerTotalPage() {
		return dao.powerTotalPage();
	}

	public List<CpuVO> cpuContentsDetail(Map map) {
		List<CpuVO> cpudetail=detaildao.CpuDetail(map);
		for(CpuVO vo:cpudetail) {
			int cpu_no = vo.getCpu_no();
			String cpu_name=vo.getCpu_name();
			String poster=vo.getPoster();
			String price=vo.getPrice();
			String company=vo.getCompany();
			String regdate=vo.getRegdate();
			String kind=vo.getKind();
			String socket=vo.getSocket();
			String core=vo.getCore();
			String thread=vo.getThread();
			String defclock=vo.getDefclock();
			int category = vo.getCategory();

			vo.setCpu_no(cpu_no);
			vo.setCpu_name(cpu_name);
			vo.setPoster(poster);
			vo.setPrice(price);
			vo.setCompany(company);
			vo.setRegdate(regdate);
			vo.setKind(kind);
			vo.setSocket(socket);
			vo.setCore(core);
			vo.setThread(thread);
			vo.setDefclock(defclock);
			vo.setCategory(category);
		}
		return cpudetail;
	}

	public List<RamVO> ramContentsDetail(Map map) {
		List<RamVO> ramdetail=detaildao.RamDetail(map);
		for(RamVO vo:ramdetail) {
			int ram_no = vo.getRam_no();
			String ram_name=vo.getRam_name();
			String poster=vo.getPoster();
			String price=vo.getPrice();
			String company=vo.getCompany();
			String regdate=vo.getRegdate();
			String kind=vo.getKind();
			String memory_capacity=vo.getMemory_capacity();
			String clock=vo.getClock();
			int category = vo.getCategory();

			vo.setRam_no(ram_no);
			vo.setRam_name(ram_name);
			vo.setPoster(poster);
			vo.setPrice(price);
			vo.setCompany(company);
			vo.setRegdate(regdate);
			vo.setKind(kind);
			vo.setMemory_capacity(memory_capacity);
			vo.setClock(clock);
			vo.setCategory(category);
		}
		return ramdetail;
	}

	public List<MainVO> mainContentsDetail(Map map) {
		List<MainVO> maindetail=detaildao.MainDetail(map);
		for(MainVO vo:maindetail) {
			int main_no = vo.getMain_no();
			String main_name=vo.getMain_name();
			String poster=vo.getPoster();
			String price=vo.getPrice();
			String company=vo.getCompany();
			String regdate=vo.getRegdate();
			String product_type=vo.getProduct_type();
			String cpu_socket=vo.getCpu_socket();
			String main_chipset=vo.getMain_chipset();
			String detail_chipset=vo.getDetail_chipset();
			String cpu_cnt=vo.getCpu_cnt();
			String formFactor=vo.getFormFactor();
			String power_supply=vo.getPower_supply();
			String memory_kind=vo.getMemory_kind();
			String memory_speed=vo.getMemory_speed();
			String memory_slot=vo.getMemory_slot();
			String memory_channel=vo.getMemory_channel();
			String memory_capacity=vo.getMemory_capacity();
			String multi_vga=vo.getMulti_vga();
			String vga_connection=vo.getVga_connection();
			String d_sub=vo.getD_sub();
			String dvi=vo.getDvi();
			String hdmi=vo.getHdmi();
			String dp=vo.getDp();
			String pcie_x16=vo.getPcie_x16();
			String pcie_x8=vo.getPcie_x8();
			String pcie_x4=vo.getPcie_x4();
			String pcie_x1=vo.getPcie_x1();
			String m2=vo.getM2();
			String sata3=vo.getSata3();
			String built_in_sound=vo.getBuilt_in_sound();
			String analog=vo.getAnalog();
			String spdif=vo.getSpdif();
			String usb_31_gen2=vo.getUsb_31_gen2();
			String usb_31_gen1=vo.getUsb_31_gen1();
			String type_c_gen2=vo.getType_c_gen2();
			String type_a_gen2=vo.getType_a_gen2();
			String type_c_gen1=vo.getType_c_gen1();
			String network_chipset=vo.getNetwork_chipset();
			String rj_45port=vo.getRj_45port();
			String gigabit_lan=vo.getGigabit_lan();
			String wireless_lan=vo.getWireless_lan();
			int category = vo.getCategory();

			vo.setMain_no(main_no);
			vo.setMain_name(main_name);
			vo.setPoster(poster);
			vo.setPrice(price);
			vo.setCompany(company);
			vo.setRegdate(regdate);
			vo.setProduct_type(product_type);
			vo.setCpu_socket(cpu_socket);
			vo.setMain_chipset(main_chipset);
			vo.setDetail_chipset(detail_chipset);
			vo.setCpu_cnt(cpu_cnt);
			vo.setFormFactor(formFactor);
			vo.setPower_supply(power_supply);
			vo.setMemory_kind(memory_kind);
			vo.setMemory_speed(memory_speed);
			vo.setMemory_slot(memory_slot);
			vo.setMemory_channel(memory_channel);
			vo.setMemory_capacity(memory_capacity);
			vo.setMulti_vga(multi_vga);
			vo.setVga_connection(vga_connection);
			vo.setD_sub(d_sub);
			vo.setDvi(dvi);
			vo.setHdmi(hdmi);
			vo.setDp(dp);
			vo.setPcie_x16(pcie_x16);
			vo.setPcie_x8(pcie_x8);
			vo.setPcie_x4(pcie_x4);
			vo.setPcie_x1(pcie_x1);
			vo.setM2(m2);
			vo.setSata3(sata3);
			vo.setBuilt_in_sound(built_in_sound);
			vo.setAnalog(analog);
			vo.setSpdif(spdif);
			vo.setUsb_31_gen2(usb_31_gen2);
			vo.setUsb_31_gen1(usb_31_gen1);
			vo.setType_c_gen2(type_c_gen2);
			vo.setType_a_gen2(type_a_gen2);
			vo.setType_c_gen1(type_c_gen1);
			vo.setNetwork_chipset(network_chipset);
			vo.setRj_45port(rj_45port);
			vo.setGigabit_lan(gigabit_lan);
			vo.setWireless_lan(wireless_lan);
			vo.setCategory(category);
		}
		return maindetail;
	}

	public List<VgaVO> vgaContentsDetail(Map map) {
		List<VgaVO> vgadetail=detaildao.VgaDetail(map);
		for(VgaVO vo:vgadetail) {
			int vga_no = vo.getVga_no();
			String vga_name=vo.getVga_name();
			String poster=vo.getPoster();
			String price=vo.getPrice();
			String company=vo.getCompany();
			String regdate=vo.getRegdate();
			String manufacturer=vo.getManufacturer();
			String manufacture_process=vo.getManufacture_process();
			String chipset=vo.getChipset();
			String series=vo.getSeries();
			String core_clock=vo.getCore_clock();
			String processor=vo.getProcessor();
			String chip_interface=vo.getChip_interface();
			String memory_kind=vo.getMemory_kind();
			String memory_capacity=vo.getMemory_capacity();
			String dvi_port=vo.getDvi_port();
			String hdmi_port=vo.getHdmi_port();
			String dp_port=vo.getDp_port();
			String sup_monitor=vo.getSup_monitor();
			String max_use_power=vo.getMax_use_power();
			String need_power=vo.getNeed_power();
			String power_port=vo.getPower_port();
			String fan=vo.getFan();
			String width=vo.getWidth();
			String height=vo.getHeight();
			int category = vo.getCategory();

			vo.setVga_no(vga_no);
			vo.setVga_name(vga_name);
			vo.setPoster(poster);
			vo.setPrice(price);
			vo.setCompany(company);
			vo.setRegdate(regdate);
			vo.setManufacturer(manufacturer);
			vo.setManufacture_process(manufacture_process);
			vo.setChipset(chipset);
			vo.setSeries(series);
			vo.setCore_clock(core_clock);
			vo.setProcessor(processor);
			vo.setChip_interface(chip_interface);
			vo.setMemory_kind(memory_kind);
			vo.setMemory_capacity(memory_capacity);
			vo.setDvi_port(dvi_port);
			vo.setHdmi_port(hdmi_port);
			vo.setDp_port(dp_port);
			vo.setSup_monitor(sup_monitor);
			vo.setMax_use_power(max_use_power);
			vo.setNeed_power(need_power);
			vo.setPower_port(power_port);
			vo.setFan(fan);
			vo.setWidth(width);
			vo.setHeight(height);
			vo.setCategory(category);
		}
		return vgadetail;
	}

	public List<SsdVO> ssdContentsDetail(Map map) {
		List<SsdVO> ssddetail=detaildao.SsdDetail(map);
		for(SsdVO vo:ssddetail) {
			int ssd_no = vo.getSsd_no();
			String ssd_name=vo.getSsd_name();
			String poster=vo.getPoster();
			String price=vo.getPrice();
			String company=vo.getCompany();
			String regdate=vo.getRegdate();
			String product_type=vo.getProduct_type();
			String disk_type=vo.getDisk_type();
			String ssd_interface=vo.getSsd_interface();
			String protocol=vo.getProtocol();
			String disk_capacity=vo.getDisk_capacity();
			String memory_type=vo.getMemory_type();
			String nand_structure=vo.getNand_structure();
			String controller=vo.getController();
			String ram_mount=vo.getRam_mount();
			String ram_type=vo.getRam_type();
			String tbw=vo.getTbw();
			String warranty_time=vo.getWarranty_time();
			int category = vo.getCategory();


			vo.setSsd_no(ssd_no);
			vo.setSsd_name(ssd_name);
			vo.setPoster(poster);
			vo.setPrice(price);
			vo.setCompany(company);
			vo.setRegdate(regdate);
			vo.setProduct_type(product_type);
			vo.setDisk_type(disk_type);
			vo.setSsd_interface(ssd_interface);
			vo.setProtocol(protocol);
			vo.setDisk_capacity(disk_capacity);
			vo.setMemory_type(memory_type);
			vo.setNand_structure(nand_structure);
			vo.setController(controller);
			vo.setRam_mount(ram_mount);
			vo.setRam_type(ram_type);
			vo.setTbw(tbw);
			vo.setWarranty_time(warranty_time);
			vo.setCategory(category);
		}
		return ssddetail;
	}

	public List<HddVO> hddContentsDetail(Map map) {
		List<HddVO> hdddetail=detaildao.HddDetail(map);
		for(HddVO vo:hdddetail) {
			int hdd_no = vo.getHdd_no();
			String hdd_name=vo.getHdd_name();
			String poster=vo.getPoster();
			String price=vo.getPrice();
			String company=vo.getCompany();
			String regdate=vo.getRegdate();
			String product_type=vo.getProduct_type();
			String disk_size=vo.getDisk_size();
			String disk_capacity=vo.getDisk_capacity();
			String hdd_interface=vo.getHdd_interface();
			String spin=vo.getSpin();
			String buffer=vo.getBuffer();
			String transfer_speed=vo.getTransfer_speed();
			String recording=vo.getRecording();
			String disk_cnt=vo.getDisk_cnt();
			String hdd_thickness=vo.getHdd_thickness();
			String workload_rate=vo.getWorkload_rate();
			String warranty=vo.getWarranty();
			int category = vo.getCategory();

			vo.setHdd_no(hdd_no);
			vo.setHdd_name(hdd_name);
			vo.setPoster(poster);
			vo.setPrice(price);
			vo.setCompany(company);
			vo.setRegdate(regdate);
			vo.setProduct_type(product_type);
			vo.setDisk_size(disk_size);
			vo.setHdd_interface(hdd_interface);
			vo.setSpin(spin);
			vo.setDisk_capacity(disk_capacity);
			vo.setBuffer(buffer);
			vo.setTransfer_speed(transfer_speed);
			vo.setRecording(recording);
			vo.setDisk_cnt(disk_cnt);
			vo.setHdd_thickness(hdd_thickness);
			vo.setWorkload_rate(workload_rate);
			vo.setWarranty(warranty);
			vo.setCategory(category);
		}
		return hdddetail;
	}

	public List<PowerVO> powerContentsDetail(Map map) {
		List<PowerVO> powerdetail=detaildao.PowerDetail(map);
		for(PowerVO vo:powerdetail) {
			int power_no = vo.getPower_no();
			String power_name=vo.getPower_name();
			String poster=vo.getPoster();
			String price=vo.getPrice();
			String company=vo.getCompany();
			String regdate=vo.getRegdate();
			String product_type=vo.getProduct_type();
			String rated_power=vo.getRated_power();
			String main_connector=vo.getMain_connector();
			String fan_size=vo.getFan_size();
			String fan_cnt=vo.getFan_cnt();
			String bearing=vo.getBearing();
			String pfc_circuit=vo.getPfc_circuit();
			String depth=vo.getDepth();
			String voltage_specification=vo.getVoltage_specification();
			String way_to_output_12v=vo.getWay_to_output_12v();
			String output12v=vo.getOutput12v();
			String output5v=vo.getOutput5v();
			String output3_3v=vo.getOutput3_3v();
			String connector_4pinIDE=vo.getConnector_4pinIDE();
			String connector_sata=vo.getConnector_sata();
			String connector_6pinPCIe=vo.getConnector_6pinPCIe();
			String connector_8pinPCIe=vo.getConnector_8pinPCIe();
			String connector_4by4pinSub=vo.getConnector_4by4pinSub();
			String connector_8pinSub=vo.getConnector_8pinSub();
			String connector_4pinSub=vo.getConnector_4pinSub();
			String connector_fdd=vo.getConnector_fdd();
			String connector_led=vo.getConnector_led();
			String cable_attached=vo.getCable_attached();
			String stanby_power=vo.getStanby_power();
			String flat_cable=vo.getFlat_cable();
			String warranty=vo.getWarranty();
			int category = vo.getCategory();

			vo.setPower_no(power_no);
			vo.setPower_name(power_name);
			vo.setPoster(poster);
			vo.setPrice(price);
			vo.setCompany(company);
			vo.setRegdate(regdate);
			vo.setProduct_type(product_type);
			vo.setRated_power(rated_power);
			vo.setMain_connector(main_connector);
			vo.setFan_size(fan_size);
			vo.setFan_cnt(fan_cnt);
			vo.setBearing(bearing);
			vo.setPfc_circuit(pfc_circuit);
			vo.setDepth(depth);
			vo.setVoltage_specification(voltage_specification);
			vo.setWay_to_output_12v(way_to_output_12v);
			vo.setOutput12v(output12v);
			vo.setOutput5v(output5v);
			vo.setOutput3_3v(output3_3v);
			vo.setConnector_4pinIDE(connector_4pinIDE);
			vo.setConnector_sata(connector_sata);
			vo.setConnector_6pinPCIe(connector_6pinPCIe);
			vo.setConnector_8pinPCIe(connector_8pinPCIe);
			vo.setConnector_4by4pinSub(connector_4by4pinSub);
			vo.setConnector_8pinSub(connector_8pinSub);
			vo.setConnector_4pinSub(connector_4pinSub);
			vo.setConnector_fdd(connector_fdd);
			vo.setConnector_led(connector_led);
			vo.setCable_attached(cable_attached);
			vo.setStanby_power(stanby_power);
			vo.setFlat_cable(flat_cable);
			vo.setWarranty(warranty);
			vo.setCategory(category);
		}
		return powerdetail;
	}
}
