import 'package:pigeon/pigeon.dart';

@ConfigurePigeon(PigeonOptions(
  dartOut: 'lib/pigeon/messages.g.dart',
  dartOptions: DartOptions(),
  kotlinOut:
      'android/app/src/main/kotlin/com/example/simple_flutter_app/Messages.g.kt',
  kotlinOptions: KotlinOptions(),
  dartPackageName: 'pigeon_example_package',
))
class MessageData {
  MessageData({required this.data});

  String? name;
  String? description;
  Map<String?, String?> data;
}

@HostApi()
abstract class AndroidHostApi {

  @async
  void openFragment(String name);

  @async
  bool sendMessage(MessageData message);
}
